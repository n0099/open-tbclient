package c.a.h.b;

import android.content.Context;
import c.a.s0.x.m;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice), 6);
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
        this.f14191d = R.drawable.icon_pure_post_voice24;
        this.f14192e = R.drawable.icon_mask_post_keyboard24_selection;
        this.f14194g = false;
        this.f14195h = true;
        this.l = 6;
        this.m = true;
        this.k = new NewVoiceRecordButton(context);
        this.n = new int[]{1, 9};
    }

    @Override // c.a.s0.x.m
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
                String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
                if (StringUtils.isNull(uegVoiceWarning)) {
                    uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
                }
                UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
                return false;
            }
            return super.a();
        }
        return invokeV.booleanValue;
    }
}
