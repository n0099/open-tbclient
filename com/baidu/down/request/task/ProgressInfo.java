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
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Segment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long begin;
        public long current;
        public long end;

        public Segment(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.begin = 0L;
            this.end = 0L;
            this.current = 0L;
            this.begin = j;
            this.current = j;
            this.end = j2;
        }
    }

    public ProgressInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentLength = 0;
        this.mSegments = new ArrayList();
    }

    public long getCurrentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCurrentLength;
        }
        return invokeV.longValue;
    }

    public int getSegmentCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mSegments.size();
        }
        return invokeV.intValue;
    }

    public List<Segment> getSegments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mSegments;
        }
        return (List) invokeV.objValue;
    }

    public ProgressInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                Segment segment = new Segment(jSONObject.getLong("begin"), jSONObject.getLong("end"));
                long j = jSONObject.getLong(JSON_KEY_CURRENT);
                segment.current = j;
                this.mCurrentLength = (int) (this.mCurrentLength + (j - segment.begin));
                this.mSegments.add(segment);
            }
        } catch (JSONException unused) {
        }
    }

    public void addSegment(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.mSegments.add(new Segment(j, j2));
        }
    }

    public synchronized List<Segment> balanceSegment(int i, long j) {
        InterceptResult invokeCommon;
        ArrayList arrayList;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            synchronized (this) {
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
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public void checkSegEnd(long j) throws HandleProgressException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            for (Segment segment : this.mSegments) {
                long j2 = segment.end;
                if (j2 == j && segment.current == j2) {
                    return;
                }
            }
        }
    }

    public long getSegCurrentByPos(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            Segment segment = getSegment(j);
            if (segment == null) {
                return 0L;
            }
            return segment.current;
        }
        return invokeJ.longValue;
    }

    public long getSegEndByPos(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            Segment segment = getSegment(j);
            if (segment == null) {
                return 0L;
            }
            return segment.end;
        }
        return invokeJ.longValue;
    }

    public Segment getSegment(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            for (Segment segment : this.mSegments) {
                if (segment.begin <= j && segment.end > j) {
                    return segment;
                }
            }
            return null;
        }
        return (Segment) invokeJ.objValue;
    }

    public boolean leftSegmentIsNeedMultiSrc(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            int i2 = 0;
            for (Segment segment : this.mSegments) {
                if (segment.end - segment.current > j) {
                    i2++;
                }
            }
            if (i2 < i) {
                return false;
            }
            return true;
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
                    jSONObject.put("begin", segment.begin);
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

    public void updateProgress(long j, long j2) throws HandleProgressException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
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
    }
}
