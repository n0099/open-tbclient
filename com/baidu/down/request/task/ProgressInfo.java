package com.baidu.down.request.task;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ProgressInfo {
    public static final boolean DEBUG = false;
    public static final String JSON_KEY_BEGIN = "begin";
    public static final String JSON_KEY_CURRENT = "current";
    public static final String JSON_KEY_END = "end";
    public static final String TAG = "ProgressInfo";
    public int mCurrentLength;
    public List<Segment> mSegments;

    /* loaded from: classes.dex */
    public static class HandleProgressException extends RuntimeException {
        public static final long serialVersionUID = -1207561809132867949L;

        public HandleProgressException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static class Segment {
        public long begin;
        public long current;
        public long end;

        public Segment(long j, long j2) {
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

    public void addSegment(long j, long j2) {
        this.mSegments.add(new Segment(j, j2));
    }

    public synchronized List<Segment> balanceSegment(int i, long j) {
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        Iterator<Segment> it = this.mSegments.iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            Segment next = it.next();
            if (next.current < next.end) {
                if (arrayList2.size() > 0) {
                    Segment segment = (Segment) arrayList2.get(0);
                    if (segment.end - segment.current >= next.end - next.current) {
                        arrayList2.add(next);
                    } else {
                        arrayList2.add(0, next);
                    }
                } else {
                    arrayList2.add(next);
                }
            }
        }
        if (arrayList2.size() < i) {
            int size = arrayList2.size();
            while (size < i) {
                if (i2 >= arrayList2.size()) {
                    break;
                }
                Segment segment2 = (Segment) arrayList2.get(i2);
                long j2 = (segment2.end - segment2.current) / 2;
                if (j2 <= j) {
                    break;
                }
                long j3 = (((j2 + AbstractTask.bufferSize) - 1) / AbstractTask.bufferSize) * AbstractTask.bufferSize;
                Segment segment3 = new Segment(segment2.end - j3, segment2.end);
                segment2.end -= j3;
                this.mSegments.add(segment3);
                arrayList.add(segment3);
                size++;
                i2++;
            }
        }
        return arrayList;
    }

    public void checkSegEnd(long j) throws HandleProgressException {
        for (Segment segment : this.mSegments) {
            long j2 = segment.end;
            if (j2 == j && segment.current == j2) {
                return;
            }
        }
    }

    public long getCurrentLength() {
        return this.mCurrentLength;
    }

    public long getSegCurrentByPos(long j) {
        Segment segment = getSegment(j);
        if (segment == null) {
            return 0L;
        }
        return segment.current;
    }

    public long getSegEndByPos(long j) {
        Segment segment = getSegment(j);
        if (segment == null) {
            return 0L;
        }
        return segment.end;
    }

    public Segment getSegment(long j) {
        for (Segment segment : this.mSegments) {
            if (segment.begin <= j && segment.end > j) {
                return segment;
            }
        }
        return null;
    }

    public int getSegmentCount() {
        return this.mSegments.size();
    }

    public List<Segment> getSegments() {
        return this.mSegments;
    }

    public boolean leftSegmentIsNeedMultiSrc(int i, long j) {
        int i2 = 0;
        for (Segment segment : this.mSegments) {
            if (segment.end - segment.current > j) {
                i2++;
            }
        }
        return i2 >= i;
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
            } catch (JSONException unused) {
            }
        }
        return jSONArray.toString();
    }

    public void updateProgress(long j, long j2) throws HandleProgressException {
        this.mCurrentLength = 0;
        for (Segment segment : this.mSegments) {
            if (segment.begin <= j) {
                long j3 = segment.end;
                if (j3 > j) {
                    long j4 = segment.current;
                    if (j4 >= j) {
                        long j5 = j + j2;
                        if (j4 <= j5) {
                            if (j3 > j5) {
                                j3 = j5;
                            }
                            segment.current = j3;
                        }
                    }
                }
            }
            this.mCurrentLength = (int) (this.mCurrentLength + (segment.current - segment.begin));
        }
    }

    public ProgressInfo(String str) {
        this.mCurrentLength = 0;
        this.mSegments = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Segment segment = new Segment(jSONObject.getLong(JSON_KEY_BEGIN), jSONObject.getLong(JSON_KEY_END));
                long j = jSONObject.getLong(JSON_KEY_CURRENT);
                segment.current = j;
                this.mCurrentLength = (int) (this.mCurrentLength + (j - segment.begin));
                this.mSegments.add(segment);
            }
        } catch (JSONException unused) {
        }
    }
}
