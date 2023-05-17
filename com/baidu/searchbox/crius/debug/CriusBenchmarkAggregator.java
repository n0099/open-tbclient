package com.baidu.searchbox.crius.debug;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class CriusBenchmarkAggregator {
    public long mLastTraceStart;
    public long mMax;
    public long mMean;
    public long mMin;
    public long mP10;
    public long mP50;
    public long mP90;
    public boolean mStatsFresh;
    public long mStddev;
    public long mVariance;
    public String name;
    public List<Long> mTimes = new ArrayList();
    public boolean tracing = false;

    public CriusBenchmarkAggregator(String str) {
        this.name = str;
    }

    private void computeStats() {
        if (this.mStatsFresh) {
            return;
        }
        Collections.sort(this.mTimes);
        this.mMin = Long.MAX_VALUE;
        this.mMax = -1L;
        this.mMean = 0L;
        for (Long l : this.mTimes) {
            long longValue = l.longValue();
            this.mMean += longValue;
            if (longValue < this.mMin) {
                this.mMin = longValue;
            }
            if (longValue > this.mMax) {
                this.mMax = longValue;
            }
        }
        this.mMean /= this.mTimes.size();
        this.mVariance = 0L;
        for (Long l2 : this.mTimes) {
            long longValue2 = l2.longValue();
            long j = this.mVariance;
            long j2 = this.mMean;
            this.mVariance = j + ((longValue2 - j2) * (longValue2 - j2));
        }
        long size = this.mVariance / this.mTimes.size();
        this.mVariance = size;
        this.mStddev = (long) Math.sqrt(size);
        List<Long> list = this.mTimes;
        this.mP10 = list.get((list.size() * 10) / 100).longValue();
        List<Long> list2 = this.mTimes;
        this.mP50 = list2.get((list2.size() * 50) / 100).longValue();
        List<Long> list3 = this.mTimes;
        this.mP90 = list3.get((list3.size() * 90) / 100).longValue();
        this.mStatsFresh = true;
    }

    public void dump(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            Log.e("CriusLayoutBenchmark", "No external file storage");
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), simpleDateFormat.format(new Date()) + "_" + this.name.replace(WebvttCueParser.CHAR_SPACE, '_'));
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for (Long l : this.mTimes) {
                printWriter.println(l.longValue());
            }
            printWriter.close();
            Log.i("CriusLayoutBenchmark", "Benchmark data saved in " + file.getPath());
        } catch (IOException e) {
            Log.e("CriusLayoutBenchmark", "Could not save benchmark data", e);
        }
    }

    public void endTrace() {
        if (!this.tracing && AppConfig.isDebug()) {
            throw new RuntimeException("Cannot stop trace if none are running!");
        }
        this.mTimes.add(Long.valueOf(System.nanoTime() - this.mLastTraceStart));
        this.tracing = false;
        this.mStatsFresh = false;
    }

    public void startTrace() {
        if (this.tracing && AppConfig.isDebug()) {
            throw new RuntimeException("Cannot start trace while running previous one");
        }
        this.tracing = true;
        this.mLastTraceStart = System.nanoTime();
    }

    public String toString() {
        computeStats();
        return String.format("%s:\n| %d samples\n| Mean %.3f±%.3fms\n| Min %.3fms ; Max %.3fms\n| p10 %.3fms ; p50 %.3fms ; p90 %.3fms\n", this.name, Integer.valueOf(this.mTimes.size()), Double.valueOf(this.mMean / 1.0E7d), Double.valueOf(this.mStddev / 1.0E7d), Double.valueOf(this.mMin / 1.0E7d), Double.valueOf(this.mMax / 1.0E7d), Double.valueOf(this.mP10 / 1.0E7d), Double.valueOf(this.mP50 / 1.0E7d), Double.valueOf(this.mP90 / 1.0E7d));
    }
}
