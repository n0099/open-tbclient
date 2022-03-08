package c.a.r0.h2.b;

import android.content.Context;
import c.a.q0.w.m;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, context.getString(R.string.editor_privilege), 12);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14000d = R.drawable.icon_pure_post_bubble24;
        this.f14002f = R.drawable.icon_pure_post_more_bubble64;
        this.f14001e = R.drawable.icon_mask_post_keyboard24_selection;
        this.p = R.drawable.icon_pure_pic_vip64;
        this.f14003g = false;
        this.f14004h = true;
        this.m = true;
        CommonTabHost commonTabHost = new CommonTabHost(context);
        this.k = commonTabHost;
        commonTabHost.addTab(new a());
        this.l = 6;
        this.n = new int[]{1};
    }
}
