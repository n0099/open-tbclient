package com.baidu.tbadk.core.util;

import android.content.Context;
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
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tieba.fb;
import com.baidu.tieba.hv4;
import com.baidu.tieba.n9;
import com.baidu.tieba.nu4;
import com.baidu.tieba.ox4;
import com.baidu.tieba.r9;
import com.baidu.tieba.w9;
import com.baidu.tieba.yo4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
        public r9 context;

        public NoLineClickableSpan(r9 r9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = r9Var;
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

    public static boolean checkAndShowFullBrowseModeDialog(r9 r9Var, IAcceptPrivacyConfirm iAcceptPrivacyConfirm) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, r9Var, iAcceptPrivacyConfirm)) == null) {
            boolean checkIsFullBrowseMode = checkIsFullBrowseMode();
            if (checkIsFullBrowseMode) {
                showDialog(r9Var, iAcceptPrivacyConfirm);
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
            MessageManager.getInstance().addMessageRule(new fb(0) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.5
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
                @Override // com.baidu.tieba.jb
                public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                        if (customMessage != null && FullBrowseHelper.checkIsFullBrowseMode()) {
                            Object data = customMessage.getData();
                            if ((data instanceof IntentConfig) && ((IntentConfig) data).getContext() != null) {
                                Class<?> cls = data.getClass();
                                if (LoginActivityConfig.class == cls) {
                                    FullBrowseHelper.showDialog(w9.a(n9.g().b()), new IAcceptPrivacyConfirm(this, customMessage) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.5.1
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
                                        FullBrowseHelper.showDialog(w9.a(n9.g().b()), null);
                                    }
                                    return null;
                                }
                            } else if (customMessage.getCmd() == 2002015 || customMessage.getCmd() == 2921361) {
                                FullBrowseHelper.showDialog(w9.a(n9.g().b()), null);
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

    public static void showDialog(r9 r9Var, IAcceptPrivacyConfirm iAcceptPrivacyConfirm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, r9Var, iAcceptPrivacyConfirm) == null) {
            View inflate = LayoutInflater.from(r9Var.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d035b, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a91);
            inflate.findViewById(R.id.obfuscated_res_0x7f091ad6).setVisibility(0);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ad7);
            hv4.d(textView2).v(R.color.CAM_X0107);
            textView2.setHighlightColor(0);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a92);
            TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a8d);
            textView.setText(R.string.obfuscated_res_0x7f0f10ed);
            String string = r9Var.getResources().getString(R.string.obfuscated_res_0x7f0f10ee);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new NoLineClickableSpan(r9Var, r9Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ r9 val$pageContext;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9Var);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9Var, r9Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((r9) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$pageContext = r9Var;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        Context context = this.val$pageContext.getContext();
                        yo4.l(context, TbConfig.TIEBA_ADDRESS + "tb/mobile/wisemainstatic/secretright.html");
                    }
                }
            }, 47, 53, 33);
            spannableString.setSpan(new NoLineClickableSpan(r9Var, r9Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ r9 val$pageContext;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9Var);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9Var, r9Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((r9) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$pageContext = r9Var;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        yo4.l(this.val$pageContext.getContext(), "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
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
            nu4 nu4Var = new nu4(r9Var.getPageActivity());
            nu4Var.setContentView(inflate);
            nu4Var.setContentViewSize(8);
            nu4Var.setCanceledOnTouchOutside(false);
            nu4Var.setAutoNight(true);
            nu4Var.setCancelable(false);
            hv4 d = hv4.d(textView3);
            d.n(R.string.J_X07);
            d.f(R.color.CAM_X0303);
            SkinManager.setViewTextColorSelector(textView3, R.color.CAM_X0101, R.color.CAM_X0618, 0);
            SkinManager.setViewTextColorSelector(textView4, R.color.CAM_X0110, R.color.CAM_X0110, 0);
            textView3.setOnClickListener(new View.OnClickListener(iAcceptPrivacyConfirm, nu4Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IAcceptPrivacyConfirm val$acceptPrivacyConfirm;
                public final /* synthetic */ nu4 val$mPrivateDialog;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iAcceptPrivacyConfirm, nu4Var};
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
                    this.val$mPrivateDialog = nu4Var;
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
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_CLICK).param("obj_source", 4).param("obj_type", 2).param("obj_locate", ox4.k().l("app_restart_times", 0) >= 2 ? 2 : 1));
                        this.val$mPrivateDialog.dismiss();
                    }
                }
            });
            textView4.setOnClickListener(new View.OnClickListener(nu4Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ nu4 val$mPrivateDialog;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nu4Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$mPrivateDialog = nu4Var;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_CLICK).param("obj_source", 4).param("obj_type", 1).param("obj_locate", ox4.k().l("app_restart_times", 0) >= 2 ? 2 : 1));
                        this.val$mPrivateDialog.dismiss();
                    }
                }
            });
            nu4Var.create(r9Var);
            nu4Var.show();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_EXPOSURE).addParam("obj_type", 4).addParam("obj_locate", ox4.k().l("app_restart_times", 0) < 2 ? 1 : 2));
            hv4.d(textView).v(R.color.CAM_X0105);
            WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090c26), R.drawable.obfuscated_res_0x7f0805a7, null);
            hv4.d((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c29)).v(R.color.CAM_X0105);
            WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090c27), R.drawable.obfuscated_res_0x7f0805a5, null);
            hv4.d((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c2a)).v(R.color.CAM_X0105);
            WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090c28), R.drawable.obfuscated_res_0x7f0805a6, null);
            hv4.d((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c2b)).v(R.color.CAM_X0105);
        }
    }
}
