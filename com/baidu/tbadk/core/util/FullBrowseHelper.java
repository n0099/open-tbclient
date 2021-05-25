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
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.c.c.f.b;
import d.a.m0.l.a;
import d.a.m0.r.u.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class FullBrowseHelper {
    public static final int ACCOUNT_PROTOCOL_END = 60;
    public static final int ACCOUNT_PROTOCOL_START = 54;
    public static final int PRIVICY_END = 53;
    public static final int PRIVICY_START = 47;

    /* loaded from: classes3.dex */
    public interface IAcceptPrivacyConfirm {
        void onConfirm();
    }

    /* loaded from: classes3.dex */
    public static abstract class NoLineClickableSpan extends ClickableSpan {
        public f context;

        public NoLineClickableSpan(f fVar) {
            this.context = fVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SkinManager.getColor(R.color.CAM_X0303));
        }
    }

    public static boolean checkAndShowFullBrowseModeDialog(f fVar, IAcceptPrivacyConfirm iAcceptPrivacyConfirm) {
        boolean checkIsFullBrowseMode = checkIsFullBrowseMode();
        if (checkIsFullBrowseMode) {
            showDialog(fVar, iAcceptPrivacyConfirm);
        }
        return checkIsFullBrowseMode;
    }

    public static boolean checkIsFullBrowseMode() {
        return !PermissionUtil.isAgreePrivacyPolicy();
    }

    public static void registerBrowseModeRule() {
        if (checkIsFullBrowseMode()) {
            MessageManager.getInstance().addMessageRule(new b(0) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.a.c.c.f.f
                public CustomMessage<?> process(final CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                    if (customMessage != null && FullBrowseHelper.checkIsFullBrowseMode()) {
                        Object data = customMessage.getData();
                        if ((data instanceof IntentConfig) && ((IntentConfig) data).getContext() != null) {
                            Class<?> cls = data.getClass();
                            if (LoginActivityConfig.class == cls) {
                                FullBrowseHelper.showDialog(j.a(d.a.c.a.b.f().b()), new IAcceptPrivacyConfirm() { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.5.1
                                    @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
                                    public void onConfirm() {
                                        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                                        if (confignation != null && !confignation.isAgreeDangerousProtocol()) {
                                            confignation.setAgreeDangerousProtocol(true);
                                        }
                                        MessageManager.getInstance().sendMessage(customMessage);
                                    }
                                });
                                return null;
                            } else if (MainTabActivityConfig.class != cls && PbActivityConfig.class != cls && FrsActivityConfig.class != cls && ImageViewerConfig.class != cls && LogoActivityConfig.class != cls) {
                                if (InterestGuideActivityConfig.class != cls && NewUserRedPackageActivityConfig.class != cls) {
                                    FullBrowseHelper.showDialog(j.a(d.a.c.a.b.f().b()), null);
                                }
                                return null;
                            }
                        } else if (customMessage.getCmd() == 2002015 || customMessage.getCmd() == 2921361) {
                            FullBrowseHelper.showDialog(j.a(d.a.c.a.b.f().b()), null);
                            return null;
                        }
                    }
                    return customMessage;
                }
            });
        }
    }

    public static void showDialog(final f fVar, final IAcceptPrivacyConfirm iAcceptPrivacyConfirm) {
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.full_browse_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.private_title);
        inflate.findViewById(R.id.protocol_layout).setVisibility(0);
        TextView textView2 = (TextView) inflate.findViewById(R.id.protocol_scrollable_textview);
        c.d(textView2).s(R.color.CAM_X0107);
        textView2.setHighlightColor(0);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView4 = (TextView) inflate.findViewById(R.id.private_no);
        textView.setText(R.string.secret_full_browse_mode_hint_head);
        String string = fVar.getResources().getString(R.string.secret_full_browse_mode_tips);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new NoLineClickableSpan(fVar) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.1
            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                a.j(fVar.getContext(), "http://tieba.baidu.com/tb/cms/client/wise_secretright.html");
            }
        }, 47, 53, 33);
        spannableString.setSpan(new NoLineClickableSpan(fVar) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.2
            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                a.j(fVar.getContext(), "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
            }
        }, 54, 60, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(string);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setText(spannableString);
        final d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(fVar.getPageActivity());
        aVar.setContentView(inflate);
        aVar.setContentViewSize(8);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setAutoNight(true);
        aVar.setCancelable(false);
        c d2 = c.d(textView3);
        d2.m(R.string.J_X07);
        d2.f(R.color.CAM_X0303);
        SkinManager.setViewTextColorSelector(textView3, R.color.CAM_X0101, R.color.CAM_X0618, 0);
        int i2 = R.color.CAM_X0110;
        SkinManager.setViewTextColorSelector(textView4, i2, i2, 0);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PermissionUtil.setIsAgreePrivacyPolicy(true);
                TbSingleton.getInstance().setBrowseMode(false);
                IAcceptPrivacyConfirm iAcceptPrivacyConfirm2 = IAcceptPrivacyConfirm.this;
                if (iAcceptPrivacyConfirm2 != null) {
                    iAcceptPrivacyConfirm2.onConfirm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921562, Boolean.FALSE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921563));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_CLICK).param("obj_source", 4).param("obj_type", 2));
                aVar.dismiss();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_CLICK).param("obj_source", 4).param("obj_type", 1));
                d.a.m0.r.s.a.this.dismiss();
            }
        });
        aVar.create(fVar);
        aVar.show();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.WINDOW_EXPOSURE).addParam("obj_type", 4));
        c.d(textView).s(R.color.CAM_X0105);
        WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.full_browse_image1), R.drawable.full_mode_icon_mask_recommend1, null);
        c.d((TextView) inflate.findViewById(R.id.full_browse_image_text1)).s(R.color.CAM_X0105);
        WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.full_browse_image2), R.drawable.full_mode_icon_mask_interaction2, null);
        c.d((TextView) inflate.findViewById(R.id.full_browse_image_text2)).s(R.color.CAM_X0105);
        WebPManager.setMaskDrawable((ImageView) inflate.findViewById(R.id.full_browse_image3), R.drawable.full_mode_icon_mask_lssue3, null);
        c.d((TextView) inflate.findViewById(R.id.full_browse_image_text3)).s(R.color.CAM_X0105);
    }
}
