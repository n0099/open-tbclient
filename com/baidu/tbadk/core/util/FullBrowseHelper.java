package com.baidu.tbadk.core.util;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.j0.l.a;
import d.a.j0.r.u.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class FullBrowseHelper {
    public static final int ACCOUNT_PROTOCOL_END = 60;
    public static final int ACCOUNT_PROTOCOL_START = 54;
    public static final int PRIVICY_END = 53;
    public static final int PRIVICY_START = 47;

    /* loaded from: classes3.dex */
    public static abstract class NoLineClickableSpan extends ClickableSpan {
        public TbPageContext context;

        public NoLineClickableSpan(TbPageContext tbPageContext) {
            this.context = tbPageContext;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.context.getResources().getColor(R.color.CAM_X0303));
        }
    }

    public static boolean checkAndShowFullBrowseModeDialog(TbPageContext tbPageContext) {
        boolean checkIsFullBrowseMode = checkIsFullBrowseMode();
        if (checkIsFullBrowseMode) {
            showDialog(tbPageContext);
        }
        return checkIsFullBrowseMode;
    }

    public static boolean checkIsFullBrowseMode() {
        return false;
    }

    public static void showDialog(final TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.full_browse_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.protocol_layout).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.protocol_scrollable_textview);
        textView.setHighlightColor(0);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_full_browse_mode_hint_head);
        String string = tbPageContext.getResources().getString(R.string.secret_full_browse_mode_tips);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new NoLineClickableSpan(tbPageContext) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.1
            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                a.j(tbPageContext.getContext(), "http://tieba.baidu.com/tb/cms/client/wise_secretright.html");
            }
        }, 47, 53, 33);
        spannableString.setSpan(new NoLineClickableSpan(tbPageContext) { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.2
            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                a.j(tbPageContext.getContext(), "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
            }
        }, 54, 60, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(string);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        final d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(tbPageContext.getPageActivity());
        aVar.setContentView(inflate);
        aVar.setContentViewSize(7);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setAutoNight(false);
        aVar.setCancelable(false);
        c d2 = c.d(textView2);
        d2.k(R.string.J_X01);
        d2.f(R.color.CAM_X0303);
        SkinManager.setViewTextColorSelector(textView2, R.color.CAM_X0101, R.color.CAM_X0618, 0);
        int i2 = R.color.CAM_X0110;
        SkinManager.setViewTextColorSelector(textView3, i2, i2, 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.j0.r.s.a.this.dismiss();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.FullBrowseHelper.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.j0.r.s.a.this.dismiss();
            }
        });
        aVar.create(tbPageContext);
        aVar.show();
    }
}
