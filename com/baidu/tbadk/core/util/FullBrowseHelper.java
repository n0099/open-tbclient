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
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.ab;
import com.baidu.tieba.g55;
import com.baidu.tieba.h9;
import com.baidu.tieba.l9;
import com.baidu.tieba.r9;
import com.baidu.tieba.s75;
import com.baidu.tieba.ux4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class FullBrowseHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCOUNT_PROTOCOL_END = 60;
    public static final int ACCOUNT_PROTOCOL_START = 54;
    public static final int PRIVICY_END = 53;
    public static final int PRIVICY_START = 47;
    public static final int WINDOW_CLICK_OBJ_TYPE_NO = 2;
    public static final int WINDOW_CLICK_OBJ_TYPE_YES = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static abstract class NoLineClickableSpan extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public l9 context;

        public NoLineClickableSpan(l9 l9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = l9Var;
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

    public static boolean checkIsFullBrowseMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return PermissionUtil.isBrowseMode();
        }
        return invokeV.booleanValue;
    }

    public static void registerBrowseModeRule() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && checkIsFullBrowseMode()) {
            MessageManager.getInstance().addMessageRule(new ab(0) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.5
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
                @Override // com.baidu.tieba.eb
                public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                        if (customMessage != null && FullBrowseHelper.checkIsFullBrowseMode()) {
                            Object data = customMessage.getData();
                            if ((data instanceof IntentConfig) && ((IntentConfig) data).getContext() != null) {
                                Class<?> cls = data.getClass();
                                if (MainTabActivityConfig.class != cls && PbActivityConfig.class != cls && FrsActivityConfig.class != cls && ImageViewerConfig.class != cls && LogoActivityConfig.class != cls) {
                                    if (InterestGuideActivityConfig.class != cls && NewUserRedPackageActivityConfig.class != cls) {
                                        FullBrowseHelper.showDialog(r9.a(h9.f().b()));
                                    }
                                    return null;
                                }
                            } else if (customMessage.getCmd() == 2002015 || customMessage.getCmd() == 2921361) {
                                FullBrowseHelper.showDialog(r9.a(h9.f().b()));
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

    public static boolean checkAndShowFullBrowseModeDialog(l9 l9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, l9Var)) == null) {
            boolean checkIsFullBrowseMode = checkIsFullBrowseMode();
            if (checkIsFullBrowseMode) {
                showDialog(l9Var);
            }
            return checkIsFullBrowseMode;
        }
        return invokeL.booleanValue;
    }

    public static void statisticClickLog(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_CLICK).param("obj_source", 4).param("obj_type", i));
        }
    }

    public static void showDialog(l9 l9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, l9Var) == null) {
            View inflate = LayoutInflater.from(l9Var.getPageActivity()).inflate(R.layout.full_browse_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.private_title);
            inflate.findViewById(R.id.protocol_layout).setVisibility(0);
            TextView textView2 = (TextView) inflate.findViewById(R.id.protocol_scrollable_textview);
            s75.d(textView2).x(R.color.CAM_X0107);
            textView2.setHighlightColor(0);
            TextView textView3 = (TextView) inflate.findViewById(R.id.private_yes);
            TextView textView4 = (TextView) inflate.findViewById(R.id.private_no);
            textView.setText(R.string.secret_full_browse_mode_hint_head);
            String string = l9Var.getResources().getString(R.string.secret_full_browse_mode_tips);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new NoLineClickableSpan(l9Var, l9Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l9 val$pageContext;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(l9Var);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {l9Var, l9Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((l9) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$pageContext = l9Var;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        Context context = this.val$pageContext.getContext();
                        ux4.o(context, TbConfig.TIEBA_ADDRESS + "tb/mobile/wisemainstatic/secretright.html");
                    }
                }
            }, 47, 53, 33);
            spannableString.setSpan(new NoLineClickableSpan(l9Var, l9Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l9 val$pageContext;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(l9Var);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {l9Var, l9Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((l9) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$pageContext = l9Var;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ux4.o(this.val$pageContext.getContext(), "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
                    }
                }
            }, 54, 60, 33);
            Matcher matcher = Pattern.compile("\n\n").matcher(string);
            while (matcher.find()) {
                spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
            }
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setText(spannableString);
            g55 g55Var = new g55(l9Var.getPageActivity());
            g55Var.setContentView(inflate);
            g55Var.setContentViewSize(8);
            g55Var.setCanceledOnTouchOutside(false);
            g55Var.setAutoNight(true);
            g55Var.setCancelable(false);
            s75 d = s75.d(textView3);
            d.o(R.string.J_X07);
            d.f(R.color.CAM_X0303);
            SkinManager.setViewTextColorSelector(textView3, R.color.CAM_X0101, R.color.CAM_X0618, 0);
            SkinManager.setViewTextColorSelector(textView4, R.color.CAM_X0110, R.color.CAM_X0110, 0);
            textView3.setOnClickListener(new View.OnClickListener(g55Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g55 val$mPrivateDialog;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {g55Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$mPrivateDialog = g55Var;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        PermissionUtil.doBrowseModeAgreePrivacy();
                        FullBrowseHelper.statisticClickLog(1);
                        this.val$mPrivateDialog.dismiss();
                    }
                }
            });
            textView4.setOnClickListener(new View.OnClickListener(g55Var) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g55 val$mPrivateDialog;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {g55Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$mPrivateDialog = g55Var;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                        return;
                    }
                    FullBrowseHelper.statisticClickLog(2);
                    this.val$mPrivateDialog.dismiss();
                }
            });
            g55Var.create(l9Var);
            g55Var.show();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_EXPOSURE).addParam("obj_type", 4));
            s75.d(textView).x(R.color.CAM_X0105);
            WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.full_browse_image1), R.drawable.full_mode_icon_mask_recommend1, null);
            s75.d((TextView) inflate.findViewById(R.id.full_browse_image_text1)).x(R.color.CAM_X0105);
            WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.full_browse_image2), R.drawable.full_mode_icon_mask_interaction2, null);
            s75.d((TextView) inflate.findViewById(R.id.full_browse_image_text2)).x(R.color.CAM_X0105);
            WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.full_browse_image3), R.drawable.full_mode_icon_mask_lssue3, null);
            s75.d((TextView) inflate.findViewById(R.id.full_browse_image_text3)).x(R.color.CAM_X0105);
        }
    }
}
