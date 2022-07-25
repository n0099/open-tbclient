package com.baidu.tbadk.core.util;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
import com.repackage.dr4;
import com.repackage.h9;
import com.repackage.pa;
import com.repackage.sl4;
import com.repackage.vr4;
import com.repackage.yt4;
import com.repackage.z8;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class FullBrowseHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCOUNT_PROTOCOL_END = 60;
    public static final int ACCOUNT_PROTOCOL_START = 54;
    public static final int PRIVICY_END = 53;
    public static final int PRIVICY_START = 47;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface IAcceptPrivacyConfirm {
        void onConfirm();
    }

    /* loaded from: classes3.dex */
    public static abstract class NoLineClickableSpan extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d9 context;

        public NoLineClickableSpan(d9 d9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = d9Var;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, textPaint) == null) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0303));
            }
        }
    }

    public FullBrowseHelper() {
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

    public static boolean checkAndShowFullBrowseModeDialog(d9 d9Var, IAcceptPrivacyConfirm iAcceptPrivacyConfirm) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, d9Var, iAcceptPrivacyConfirm)) == null) {
            boolean checkIsFullBrowseMode = checkIsFullBrowseMode();
            if (checkIsFullBrowseMode) {
                showDialog(d9Var, iAcceptPrivacyConfirm);
            }
            return checkIsFullBrowseMode;
        }
        return invokeLL.booleanValue;
    }

    public static boolean checkIsFullBrowseMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? !PermissionUtil.isAgreePrivacyPolicy() : invokeV.booleanValue;
    }

    public static void registerBrowseModeRule() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && checkIsFullBrowseMode()) {
            MessageManager.getInstance().addMessageRule(new pa(0) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.repackage.ta
                public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                        if (customMessage != null && FullBrowseHelper.checkIsFullBrowseMode()) {
                            Object data = customMessage.getData();
                            if ((data instanceof IntentConfig) && ((IntentConfig) data).getContext() != null) {
                                Class<?> cls = data.getClass();
                                if (LoginActivityConfig.class == cls) {
                                    FullBrowseHelper.showDialog(h9.a(z8.g().b()), new IAcceptPrivacyConfirm(this, customMessage) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.5.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass5 this$0;
                                        public final /* synthetic */ CustomMessage val$data;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, customMessage};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                            this.val$data = customMessage;
                                        }

                                        @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
                                        public void onConfirm() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                                                if (confignation != null && !confignation.isAgreeDangerousProtocol()) {
                                                    SapiAccountManager.getInstance().setAgreeDangerousProtocol(true);
                                                }
                                                MessageManager.getInstance().sendMessage(this.val$data);
                                            }
                                        }
                                    });
                                    return null;
                                } else if (MainTabActivityConfig.class != cls && PbActivityConfig.class != cls && FrsActivityConfig.class != cls && ImageViewerConfig.class != cls && LogoActivityConfig.class != cls) {
                                    if (InterestGuideActivityConfig.class != cls && NewUserRedPackageActivityConfig.class != cls) {
                                        FullBrowseHelper.showDialog(h9.a(z8.g().b()), null);
                                    }
                                    return null;
                                }
                            } else if (customMessage.getCmd() == 2002015 || customMessage.getCmd() == 2921361) {
                                FullBrowseHelper.showDialog(h9.a(z8.g().b()), null);
                                return null;
                            }
                        }
                        return customMessage;
                    }
                    return (CustomMessage) invokeLL.objValue;
                }
            });
        }
    }

    public static void showDialog(d9 d9Var, IAcceptPrivacyConfirm iAcceptPrivacyConfirm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, d9Var, iAcceptPrivacyConfirm) == null) {
            View inflate = LayoutInflater.from(d9Var.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0353, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091979);
            inflate.findViewById(R.id.obfuscated_res_0x7f0919bc).setVisibility(0);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0919bd);
            vr4.d(textView2).v(R.color.CAM_X0107);
            textView2.setHighlightColor(0);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09197a);
            TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091975);
            textView.setText(R.string.obfuscated_res_0x7f0f1093);
            String string = d9Var.getResources().getString(R.string.obfuscated_res_0x7f0f1094);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new NoLineClickableSpan(d9Var, d9Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d9 val$pageContext;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(d9Var);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {d9Var, d9Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((d9) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$pageContext = d9Var;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        sl4.l(this.val$pageContext.getContext(), "https://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html");
                    }
                }
            }, 47, 53, 33);
            spannableString.setSpan(new NoLineClickableSpan(d9Var, d9Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d9 val$pageContext;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(d9Var);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {d9Var, d9Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((d9) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$pageContext = d9Var;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        sl4.l(this.val$pageContext.getContext(), "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
                    }
                }
            }, 54, 60, 33);
            Matcher matcher = Pattern.compile("\n\n").matcher(string);
            while (true) {
                if (!matcher.find()) {
                    break;
                }
                spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
            }
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setText(spannableString);
            dr4 dr4Var = new dr4(d9Var.getPageActivity());
            dr4Var.setContentView(inflate);
            dr4Var.setContentViewSize(8);
            dr4Var.setCanceledOnTouchOutside(false);
            dr4Var.setAutoNight(true);
            dr4Var.setCancelable(false);
            vr4 d = vr4.d(textView3);
            d.n(R.string.J_X07);
            d.f(R.color.CAM_X0303);
            SkinManager.setViewTextColorSelector(textView3, R.color.CAM_X0101, R.color.CAM_X0618, 0);
            SkinManager.setViewTextColorSelector(textView4, R.color.CAM_X0110, R.color.CAM_X0110, 0);
            textView3.setOnClickListener(new View.OnClickListener(iAcceptPrivacyConfirm, dr4Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IAcceptPrivacyConfirm val$acceptPrivacyConfirm;
                public final /* synthetic */ dr4 val$mPrivateDialog;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iAcceptPrivacyConfirm, dr4Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$acceptPrivacyConfirm = iAcceptPrivacyConfirm;
                    this.val$mPrivateDialog = dr4Var;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        PermissionUtil.setIsAgreePrivacyPolicy(true);
                        TbSingleton.getInstance().setBrowseMode(false);
                        IAcceptPrivacyConfirm iAcceptPrivacyConfirm2 = this.val$acceptPrivacyConfirm;
                        if (iAcceptPrivacyConfirm2 != null) {
                            iAcceptPrivacyConfirm2.onConfirm();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921562, Boolean.FALSE));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921563));
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_CLICK).param("obj_source", 4).param("obj_type", 2).param("obj_locate", yt4.k().l("app_restart_times", 0) >= 2 ? 2 : 1));
                        this.val$mPrivateDialog.dismiss();
                    }
                }
            });
            textView4.setOnClickListener(new View.OnClickListener(dr4Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ dr4 val$mPrivateDialog;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dr4Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$mPrivateDialog = dr4Var;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_CLICK).param("obj_source", 4).param("obj_type", 1).param("obj_locate", yt4.k().l("app_restart_times", 0) >= 2 ? 2 : 1));
                        this.val$mPrivateDialog.dismiss();
                    }
                }
            });
            dr4Var.create(d9Var);
            dr4Var.show();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_EXPOSURE).addParam("obj_type", 4).addParam("obj_locate", yt4.k().l("app_restart_times", 0) < 2 ? 1 : 2));
            vr4.d(textView).v(R.color.CAM_X0105);
            WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090bcf), R.drawable.obfuscated_res_0x7f080590, null);
            vr4.d((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090bd2)).v(R.color.CAM_X0105);
            WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090bd0), R.drawable.obfuscated_res_0x7f08058e, null);
            vr4.d((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090bd3)).v(R.color.CAM_X0105);
            WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090bd1), R.drawable.obfuscated_res_0x7f08058f, null);
            vr4.d((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090bd4)).v(R.color.CAM_X0105);
        }
    }
}
