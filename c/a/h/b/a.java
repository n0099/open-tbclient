package c.a.h.b;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import c.a.o0.w.m;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, (String) null, 6);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11508b = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f130e);
        this.f11510d = R.drawable.obfuscated_res_0x7f080970;
        this.f11513g = false;
        this.f11514h = true;
        this.m = true;
        this.l = 5;
        this.k = new SendVoiceView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -2);
        ((LinearLayout.LayoutParams) layoutParams).leftMargin = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229);
        ((LinearLayout.LayoutParams) layoutParams).rightMargin = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229);
        ((LinearLayout.LayoutParams) layoutParams).topMargin = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070270);
        ((LinearLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
        ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
        ((View) this.k).setLayoutParams(layoutParams);
        this.n = new int[0];
    }
}
