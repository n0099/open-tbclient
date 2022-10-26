package androidx.media2.common;

import androidx.core.util.ObjectsCompat;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class SubtitleData implements VersionedParcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SubtitleData";
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] mData;
    public long mDurationUs;
    public long mStartTimeUs;

    public SubtitleData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public byte[] getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mData;
        }
        return (byte[]) invokeV.objValue;
    }

    public long getDurationUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDurationUs;
        }
        return invokeV.longValue;
    }

    public long getStartTimeUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mStartTimeUs;
        }
        return invokeV.longValue;
    }

    public SubtitleData(long j, long j2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStartTimeUs = j;
        this.mDurationUs = j2;
        this.mData = bArr;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SubtitleData.class != obj.getClass()) {
                return false;
            }
            SubtitleData subtitleData = (SubtitleData) obj;
            if (this.mStartTimeUs == subtitleData.mStartTimeUs && this.mDurationUs == subtitleData.mDurationUs && Arrays.equals(this.mData, subtitleData.mData)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ObjectsCompat.hash(Long.valueOf(this.mStartTimeUs), Long.valueOf(this.mDurationUs), Integer.valueOf(Arrays.hashCode(this.mData)));
        }
        return invokeV.intValue;
    }
}
