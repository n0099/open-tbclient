package com.baidu.down.request.task;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ProgressInfo {
    private static final boolean DEBUG = false;
    private static final String JSON_KEY_BEGIN = "begin";
    private static final String JSON_KEY_CURRENT = "current";
    private static final String JSON_KEY_END = "end";
    private static final String TAG = "ProgressInfo";
    private int mCurrentLength;
    private List<Segment> mSegments;

    /* loaded from: classes3.dex */
    public static class Segment {
        public long begin;
        public long current;
        public long end;

        Segment(long j, long j2) {
            this.begin = 0L;
            this.end = 0L;
            this.current = 0L;
            this.begin = j;
            this.current = j;
            this.end = j2;
        }
    }

    public ProgressInfo() {
        this.mCurrentLength = 0;
        this.mSegments = new ArrayList();
    }

    public ProgressInfo(String str) {
        this.mCurrentLength = 0;
        this.mSegments = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    Segment segment = new Segment(jSONObject.getLong(JSON_KEY_BEGIN), jSONObject.getLong(JSON_KEY_END));
                    segment.current = jSONObject.getLong(JSON_KEY_CURRENT);
                    this.mCurrentLength = (int) (this.mCurrentLength + (segment.current - segment.begin));
                    this.mSegments.add(segment);
                }
            } catch (JSONException e) {
            }
        }
    }

    public int getSegmentCount() {
        return this.mSegments.size();
    }

    public List<Segment> getSegments() {
        return this.mSegments;
    }

    public void addSegment(long j, long j2) {
        this.mSegments.add(new Segment(j, j2));
    }

    public void updateProgress(long j, long j2) throws HandleProgressException {
        this.mCurrentLength = 0;
        for (Segment segment : this.mSegments) {
            if (segment.begin <= j && segment.end > j && segment.current >= j && segment.current <= j + j2) {
                segment.current = segment.end > j + j2 ? j + j2 : segment.end;
            }
            this.mCurrentLength = (int) (this.mCurrentLength + (segment.current - segment.begin));
        }
    }

    public void checkSegEnd(long j) throws HandleProgressException {
        boolean z;
        Iterator<Segment> it = this.mSegments.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Segment next = it.next();
            if (next.end == j && next.current == next.end) {
                z = true;
                break;
            }
        }
        if (!z) {
        }
    }

    public Segment getSegment(long j) {
        for (Segment segment : this.mSegments) {
            if (segment.begin <= j && segment.end > j) {
                return segment;
            }
        }
        return null;
    }

    public long getSegEndByPos(long j) {
        Segment segment = getSegment(j);
        if (segment == null) {
            return 0L;
        }
        return segment.end;
    }

    public long getSegCurrentByPos(long j) {
        Segment segment = getSegment(j);
        if (segment == null) {
            return 0L;
        }
        return segment.current;
    }

    public long getCurrentLength() {
        return this.mCurrentLength;
    }

    public String toString() {
        JSONArray jSONArray = new JSONArray();
        for (Segment segment : this.mSegments) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(JSON_KEY_BEGIN, segment.begin);
                jSONObject.put(JSON_KEY_CURRENT, segment.current);
                jSONObject.put(JSON_KEY_END, segment.end);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        return jSONArray.toString();
    }

    public synchronized List<Segment> balanceSegment(int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        for (Segment segment : this.mSegments) {
            if (segment.current < segment.end) {
                if (arrayList2.size() > 0) {
                    Segment segment2 = (Segment) arrayList2.get(0);
                    if (segment2.end - segment2.current >= segment.end - segment.current) {
                        arrayList2.add(segment);
                    } else {
                        arrayList2.add(0, segment);
                    }
                } else {
                    arrayList2.add(segment);
                }
            }
        }
        if (arrayList2.size() < i) {
            int i2 = 0;
            for (int size = arrayList2.size(); size < i; size++) {
                if (i2 >= arrayList2.size()) {
                    break;
                }
                Segment segment3 = (Segment) arrayList2.get(i2);
                long j2 = (segment3.end - segment3.current) / 2;
                if (j2 <= j) {
                    break;
                }
                long j3 = (((j2 + AbstractTask.bufferSize) - 1) / AbstractTask.bufferSize) * AbstractTask.bufferSize;
                Segment segment4 = new Segment(segment3.end - j3, segment3.end);
                segment3.end -= j3;
                this.mSegments.add(segment4);
                arrayList.add(segment4);
                i2++;
            }
        }
        return arrayList;
    }

    public boolean leftSegmentIsNeedMultiSrc(int i, long j) {
        int i2 = 0;
        for (Segment segment : this.mSegments) {
            i2 = segment.end - segment.current > j ? i2 + 1 : i2;
        }
        return i2 >= i;
    }

    /* loaded from: classes3.dex */
    public static class HandleProgressException extends RuntimeException {
        private static final long serialVersionUID = -1207561809132867949L;

        public HandleProgressException(String str) {
            super(str);
        }
    }
}
