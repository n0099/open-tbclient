package com.baidu.down.request.task;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ProgressInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String JSON_KEY_BEGIN = "begin";
    public static final String JSON_KEY_CURRENT = "current";
    public static final String JSON_KEY_END = "end";
    public static final String TAG = "ProgressInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurrentLength;
    public List<Segment> mSegments;

    /* loaded from: classes5.dex */
    public static class HandleProgressException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1207561809132867949L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandleProgressException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class Segment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long begin;
        public long current;
        public long end;

        public Segment(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.begin = 0L;
            this.end = 0L;
            this.current = 0L;
            this.begin = j2;
            this.current = j2;
            this.end = j3;
        }
    }

    public ProgressInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentLength = 0;
        this.mSegments = new ArrayList();
    }

    public void addSegment(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.mSegments.add(new Segment(j2, j3));
        }
    }

    public synchronized List<Segment> balanceSegment(int i2, long j2) {
        InterceptResult invokeCommon;
        ArrayList arrayList;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                ArrayList arrayList2 = new ArrayList();
                arrayList = new ArrayList();
                Iterator<Segment> it = this.mSegments.iterator();
                while (true) {
                    i3 = 0;
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
                if (arrayList2.size() < i2) {
                    int size = arrayList2.size();
                    while (size < i2) {
                        if (i3 >= arrayList2.size()) {
                            break;
                        }
                        Segment segment2 = (Segment) arrayList2.get(i3);
                        long j3 = (segment2.end - segment2.current) / 2;
                        if (j3 <= j2) {
                            break;
                        }
                        long j4 = (((j3 + AbstractTask.bufferSize) - 1) / AbstractTask.bufferSize) * AbstractTask.bufferSize;
                        Segment segment3 = new Segment(segment2.end - j4, segment2.end);
                        segment2.end -= j4;
                        this.mSegments.add(segment3);
                        arrayList.add(segment3);
                        size++;
                        i3++;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public void checkSegEnd(long j2) throws HandleProgressException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            for (Segment segment : this.mSegments) {
                long j3 = segment.end;
                if (j3 == j2 && segment.current == j3) {
                    return;
                }
            }
        }
    }

    public long getCurrentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCurrentLength : invokeV.longValue;
    }

    public long getSegCurrentByPos(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
            Segment segment = getSegment(j2);
            if (segment == null) {
                return 0L;
            }
            return segment.current;
        }
        return invokeJ.longValue;
    }

    public long getSegEndByPos(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            Segment segment = getSegment(j2);
            if (segment == null) {
                return 0L;
            }
            return segment.end;
        }
        return invokeJ.longValue;
    }

    public Segment getSegment(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            for (Segment segment : this.mSegments) {
                if (segment.begin <= j2 && segment.end > j2) {
                    return segment;
                }
            }
            return null;
        }
        return (Segment) invokeJ.objValue;
    }

    public int getSegmentCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSegments.size() : invokeV.intValue;
    }

    public List<Segment> getSegments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSegments : (List) invokeV.objValue;
    }

    public boolean leftSegmentIsNeedMultiSrc(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            int i3 = 0;
            for (Segment segment : this.mSegments) {
                if (segment.end - segment.current > j2) {
                    i3++;
                }
            }
            return i3 >= i2;
        }
        return invokeCommon.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (Segment segment : this.mSegments) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(JSON_KEY_BEGIN, segment.begin);
                    jSONObject.put(JSON_KEY_CURRENT, segment.current);
                    jSONObject.put("end", segment.end);
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public void updateProgress(long j2, long j3) throws HandleProgressException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.mCurrentLength = 0;
            for (Segment segment : this.mSegments) {
                if (segment.begin <= j2) {
                    long j4 = segment.end;
                    if (j4 > j2) {
                        long j5 = segment.current;
                        if (j5 >= j2) {
                            long j6 = j2 + j3;
                            if (j5 <= j6) {
                                if (j4 > j6) {
                                    j4 = j6;
                                }
                                segment.current = j4;
                            }
                        }
                    }
                }
                this.mCurrentLength = (int) (this.mCurrentLength + (segment.current - segment.begin));
            }
        }
    }

    public ProgressInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurrentLength = 0;
        this.mSegments = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                Segment segment = new Segment(jSONObject.getLong(JSON_KEY_BEGIN), jSONObject.getLong("end"));
                long j2 = jSONObject.getLong(JSON_KEY_CURRENT);
                segment.current = j2;
                this.mCurrentLength = (int) (this.mCurrentLength + (j2 - segment.begin));
                this.mSegments.add(segment);
            }
        } catch (JSONException unused) {
        }
    }
}
