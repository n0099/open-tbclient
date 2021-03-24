package com.baidu.rtc;

import android.os.Environment;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.rtc.RTCAudioSamples;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public class RtcAudioDumper implements RTCAudioSamples.RTCSamplesReadyCallback, RTCAudioSamples.RTCRemoteSamplesReadyCallback {
    public static final long MAX_FILE_SIZE_IN_BYTES = 58348800;
    public static final String TAG = "RtcRemoteAudioDumper";
    public final ExecutorService executor;
    public long fileSizeInBytes;
    public boolean isRunning;
    public final Object lock = new Object();
    @Nullable
    public OutputStream rawAudioFileOutputStream;

    public RtcAudioDumper(ExecutorService executorService) {
        Log.d(TAG, "remote audio dumper created");
        this.executor = executorService;
    }

    private void dumpAudioSamples(final RTCAudioSamples rTCAudioSamples) {
        if (rTCAudioSamples.getAudioFormat() != 2) {
            Log.e(TAG, "Invalid audio format");
            return;
        }
        synchronized (this.lock) {
            if (this.isRunning) {
                if (this.rawAudioFileOutputStream == null) {
                    openRawAudioOutputFile(rTCAudioSamples.getSampleRate(), rTCAudioSamples.getChannelCount());
                    this.fileSizeInBytes = 0L;
                }
                this.executor.execute(new Runnable() { // from class: com.baidu.rtc._$$Lambda$RtcAudioDumper$1ZnweygluS0pXY78M8aBAPDyZ_M
                    @Override // java.lang.Runnable
                    public final void run() {
                        RtcAudioDumper.lambda$dumpAudioSamples$0(RtcAudioDumper.this, rTCAudioSamples);
                    }
                });
            }
        }
    }

    private boolean isExternalStorageWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static /* synthetic */ void lambda$dumpAudioSamples$0(RtcAudioDumper rtcAudioDumper, RTCAudioSamples rTCAudioSamples) {
        OutputStream outputStream = rtcAudioDumper.rawAudioFileOutputStream;
        if (outputStream != null) {
            try {
                if (rtcAudioDumper.fileSizeInBytes < MAX_FILE_SIZE_IN_BYTES) {
                    outputStream.write(rTCAudioSamples.getData());
                    rtcAudioDumper.fileSizeInBytes += rTCAudioSamples.getData().length;
                }
            } catch (IOException e2) {
                Log.e(TAG, "Failed to write audio to file: " + e2.getMessage());
            }
        }
    }

    private void openRawAudioOutputFile(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        sb.append(File.separator);
        sb.append("audio_16bits_");
        sb.append(String.valueOf(i));
        sb.append("Hz");
        sb.append(i2 == 1 ? "_mono_" : "_stereo_");
        sb.append(System.currentTimeMillis());
        sb.append(".pcm");
        String sb2 = sb.toString();
        try {
            this.rawAudioFileOutputStream = new FileOutputStream(new File(sb2));
        } catch (FileNotFoundException e2) {
            Log.e(TAG, "Failed to open audio output file: " + e2.getMessage());
        }
        Log.d(TAG, "Opened file for recording: " + sb2);
    }

    @Override // com.baidu.rtc.RTCAudioSamples.RTCSamplesReadyCallback
    public void onRtcAudioRecordSamplesReady(RTCAudioSamples rTCAudioSamples) {
        dumpAudioSamples(rTCAudioSamples);
    }

    @Override // com.baidu.rtc.RTCAudioSamples.RTCRemoteSamplesReadyCallback
    public void onRtcAudioRemoteSamplesReady(RTCAudioSamples rTCAudioSamples) {
        dumpAudioSamples(rTCAudioSamples);
    }

    public boolean start() {
        Log.d(TAG, "remote audio dumper start");
        if (!isExternalStorageWritable()) {
            Log.e(TAG, "Writing to external media is not possible");
            return false;
        }
        synchronized (this.lock) {
            this.isRunning = true;
        }
        return true;
    }

    public void stop() {
        Log.d(TAG, "remote audio dumper stop");
        synchronized (this.lock) {
            this.isRunning = false;
            if (this.rawAudioFileOutputStream != null) {
                try {
                    this.rawAudioFileOutputStream.close();
                } catch (IOException e2) {
                    Log.e(TAG, "Failed to close file with saved input audio: " + e2);
                }
                this.rawAudioFileOutputStream = null;
            }
            this.fileSizeInBytes = 0L;
        }
    }
}
