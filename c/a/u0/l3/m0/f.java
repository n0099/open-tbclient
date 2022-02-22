package c.a.u0.l3.m0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f19422b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f19423c;

    public f(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f19422b = context;
        this.f19423c = viewGroup;
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if ("apk_download".equals(str)) {
                return "apk_download".equals(str2);
            }
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str)) {
                return TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public g b(c.a.u0.l3.i0.b.g gVar, g gVar2) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, gVar2)) == null) {
            if (gVar == null || (str = gVar.a) == null) {
                return gVar2;
            }
            if (gVar2 == null || !a(str, gVar2.a)) {
                ViewGroup viewGroup = this.f19423c;
                if (viewGroup == null) {
                    return null;
                }
                viewGroup.removeAllViews();
                if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(gVar.a)) {
                    int i2 = this.a;
                    if (i2 == 1) {
                        return new e(LayoutInflater.from(this.f19422b).inflate(R.layout.videolist_tail_frame_ad_jump, this.f19423c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    }
                    if (i2 == 2) {
                        return new d(LayoutInflater.from(this.f19422b).inflate(R.layout.video_flow_tail_frame_jump, this.f19423c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    }
                    return new b(LayoutInflater.from(this.f19422b).inflate(R.layout.tail_frame_ad_jump, this.f19423c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                } else if ("apk_download".equals(gVar.a)) {
                    if (this.a == 2) {
                        return new c(LayoutInflater.from(this.f19422b).inflate(R.layout.video_flow_tail_frame_download, this.f19423c, true), "apk_download");
                    }
                    return new a(LayoutInflater.from(this.f19422b).inflate(R.layout.tail_frame_ad_download, this.f19423c, true), "apk_download");
                } else {
                    return null;
                }
            }
            return gVar2;
        }
        return (g) invokeLL.objValue;
    }
}
