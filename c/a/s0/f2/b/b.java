package c.a.s0.f2.b;

import android.content.Context;
import c.a.r0.x.m;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, context.getString(R.string.editor_privilege), 12);
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            i2 = R.drawable.icon_pure_post_bubble24;
        } catch (NoSuchFieldError e2) {
            BdLog.e(e2.getMessage());
            i2 = 0;
        }
        this.f14031d = i2;
        this.f14033f = R.drawable.icon_pure_post_more_bubble64;
        this.f14032e = R.drawable.icon_mask_post_keyboard24_selection;
        this.p = R.drawable.icon_pure_pic_vip64;
        this.f14034g = false;
        this.f14035h = true;
        this.m = true;
        CommonTabHost commonTabHost = new CommonTabHost(context);
        this.f14038k = commonTabHost;
        commonTabHost.addTab(new a());
        this.l = 6;
        this.n = new int[]{1};
    }
}
