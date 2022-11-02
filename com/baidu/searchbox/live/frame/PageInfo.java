package com.baidu.searchbox.live.frame;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.frame.State;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/frame/PageInfo;", "Lcom/baidu/live/arch/frame/State;", "", "component1", "()Z", "", "component2", "()I", "component3", "", "component4", "()J", "isUp", CriusAttrConstants.POSITION, "isFromForward", "listRequestDuration", "copy", "(ZIZJ)Lcom/baidu/searchbox/live/frame/PageInfo;", "", ImageViewerConfig.FROM_OTHER, "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "", "toString", "()Ljava/lang/String;", "Z", "J", "getListRequestDuration", "I", "getPosition", "<init>", "(ZIZJ)V", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PageInfo implements State {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String KEY = "page_info";
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean isFromForward;
    public final boolean isUp;
    public final long listRequestDuration;
    public final int position;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1848308883, "Lcom/baidu/searchbox/live/frame/PageInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1848308883, "Lcom/baidu/searchbox/live/frame/PageInfo;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, boolean z, int i, boolean z2, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = pageInfo.isUp;
        }
        if ((i2 & 2) != 0) {
            i = pageInfo.position;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            z2 = pageInfo.isFromForward;
        }
        boolean z3 = z2;
        if ((i2 & 8) != 0) {
            j = pageInfo.listRequestDuration;
        }
        return pageInfo.copy(z, i3, z3, j);
    }

    public final boolean component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isUp : invokeV.booleanValue;
    }

    public final int component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.position : invokeV.intValue;
    }

    public final boolean component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isFromForward : invokeV.booleanValue;
    }

    public final long component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.listRequestDuration : invokeV.longValue;
    }

    public final PageInfo copy(boolean z, int i, boolean z2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), Long.valueOf(j)})) == null) ? new PageInfo(z, i, z2, j) : (PageInfo) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof PageInfo) {
                    PageInfo pageInfo = (PageInfo) obj;
                    return this.isUp == pageInfo.isUp && this.position == pageInfo.position && this.isFromForward == pageInfo.isFromForward && this.listRequestDuration == pageInfo.listRequestDuration;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            boolean z = this.isUp;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = ((r0 * 31) + this.position) * 31;
            boolean z2 = this.isFromForward;
            int i2 = z2 ? 1 : z2 ? 1 : 0;
            long j = this.listRequestDuration;
            return ((i + i2) * 31) + ((int) (j ^ (j >>> 32)));
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "PageInfo(isUp=" + this.isUp + ", position=" + this.position + ", isFromForward=" + this.isFromForward + ", listRequestDuration=" + this.listRequestDuration + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/frame/PageInfo$Companion;", "", "KEY", "Ljava/lang/String;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PageInfo(boolean z, int i, boolean z2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isUp = z;
        this.position = i;
        this.isFromForward = z2;
        this.listRequestDuration = j;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PageInfo(boolean z, int i, boolean z2, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, r3, j);
        boolean z3;
        if ((i2 & 4) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
    }

    public final long getListRequestDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.listRequestDuration;
        }
        return invokeV.longValue;
    }

    public final int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.position;
        }
        return invokeV.intValue;
    }

    public final boolean isFromForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.isFromForward;
        }
        return invokeV.booleanValue;
    }

    public final boolean isUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.isUp;
        }
        return invokeV.booleanValue;
    }
}
