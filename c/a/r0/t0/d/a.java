package c.a.r0.t0.d;

import android.content.Context;
import c.a.q0.w.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i2, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14000d = R.drawable.icon_pure_post_expression24;
        this.f14001e = R.drawable.icon_pure_post_expression24_selection;
        this.f14002f = R.drawable.icon_pure_post_expression64_big;
        this.f14003g = false;
        this.f14004h = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.k = emotionTabHost;
        this.m = true;
        this.l = 6;
        this.n = new int[]{1, 34, 35};
    }

    @Override // c.a.q0.w.m
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            ((EmotionTabHost) this.k).setShowUserCollect(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i2) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14000d = R.drawable.icon_pure_post_expression24;
        this.f14001e = R.drawable.icon_mask_post_keyboard24_selection;
        this.f14002f = R.drawable.icon_pure_post_expression64_big;
        this.f14003g = false;
        this.f14004h = true;
        this.k = new EmotionTabHost(context);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1, 34, 35};
    }
}
