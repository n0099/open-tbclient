package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int eet = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private TextView ahA;
    private View.OnClickListener ahU;
    private View.OnClickListener ahw;
    private boolean aik;
    private bu aiq;
    private int dLj;
    private AgreeView edr;
    private TbRichTextVoiceInfo eeA;
    private int eeB;
    private final float eeC;
    private View.OnClickListener eeD;
    private TextView eeu;
    private PlayVoiceBntNew eev;
    private FrameLayout eew;
    private TextView eex;
    private ClickableHeaderImageView eey;
    private PostData eez;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.aiq = null;
        this.mSkinType = 3;
        this.eeC = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ahU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eez != null && ThreadGodReplyLayout.this.eez.aSp() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eez.aSp().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eez.aSp().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eez.aSp().getUserId(), ThreadGodReplyLayout.this.eez.aSp().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eez.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ahw != null) {
                        ThreadGodReplyLayout.this.ahw.onClick(view);
                    }
                }
            }
        };
        this.eeD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ahw != null) {
                    ThreadGodReplyLayout.this.ahw.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiq = null;
        this.mSkinType = 3;
        this.eeC = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ahU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eez != null && ThreadGodReplyLayout.this.eez.aSp() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eez.aSp().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eez.aSp().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eez.aSp().getUserId(), ThreadGodReplyLayout.this.eez.aSp().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eez.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ahw != null) {
                        ThreadGodReplyLayout.this.ahw.onClick(view);
                    }
                }
            }
        };
        this.eeD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ahw != null) {
                    ThreadGodReplyLayout.this.ahw.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiq = null;
        this.mSkinType = 3;
        this.eeC = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ahU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eez != null && ThreadGodReplyLayout.this.eez.aSp() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eez.aSp().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eez.aSp().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eez.aSp().getUserId(), ThreadGodReplyLayout.this.eez.aSp().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eez.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ahw != null) {
                        ThreadGodReplyLayout.this.ahw.onClick(view);
                    }
                }
            }
        };
        this.eeD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ahw != null) {
                    ThreadGodReplyLayout.this.ahw.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.eey = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.eey.setIsRound(true);
        this.eey.setClickable(true);
        this.ahA = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.ahA.setOnClickListener(this.ahU);
        this.edr = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.edr.setAfterClickListener(this.eeD);
        this.edr.setAgreeAlone(true);
        this.eeu = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.eev = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.eev.setVisibility(8);
        this.eew = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.eeB = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.dLj = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.eeB * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dLj, this.dLj);
            layoutParams.leftMargin = (this.dLj + this.eeB) * i;
            this.eew.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(an.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            tbImageView.setPlaceHolder(2);
        }
        this.eew.setVisibility(8);
        this.eex = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aYE() {
        if (this.eey != null) {
            this.eey.setPlaceHolder(1);
        }
        int childCount = this.eew.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eew.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bu buVar) {
        this.aiq = buVar;
        setData(buVar != null ? buVar.aTS() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aSp() == null || postData.aSp().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.eez = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.dia()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.eeA != null && this.eeA.blP() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!ba(this.eeu) && !ba(this.eew) && !ba(this.eev)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.eeu.setVisibility(8);
            return;
        }
        this.eeu.setVisibility(0);
        if (!v.a(this.eeC, this.eeu.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.eeu.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        s.bOA().e(new ao("c13348"));
                        ThreadGodReplyLayout.this.eeu.setMaxLines(15);
                        ThreadGodReplyLayout.this.eeu.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.eeu.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.eeu.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.eeu.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.eeu.setText(((Object) ThreadGodReplyLayout.this.eeu.getText().subSequence(0, ThreadGodReplyLayout.this.eeu.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.eeu.getPaint(), (int) this.eeC, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.eeC;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.eeC - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.eeu.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.eeu.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.eeu.setText(spannableStringBuilder);
                this.eeu.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                s.bOA().e(new ao("c13347"));
            } else {
                return;
            }
        }
        aYF();
    }

    private boolean ba(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.eey.setData(postData.aSp());
            this.ahA.setText(ar.cutChineseAndEnglishWithSuffix(postData.aSp().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.aiq != null) {
                postData.aUg().threadId = this.aiq.getTid();
            }
            postData.aUg().threadId = String.valueOf(postData.getTid());
            postData.aUg().objType = 3;
            this.edr.setData(postData.aUg());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bkO;
        if (tbRichText == null || (bkO = tbRichText.bkO()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bkO.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bkV());
            } else if (next.getType() == 17) {
                String str = next.bkZ().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    spannableStringBuilder.append((CharSequence) "[表情]");
                }
            } else if (next.getType() == 20) {
                spannableStringBuilder.append((CharSequence) "[表情]");
            }
        }
        if (spannableStringBuilder.length() > 0) {
            for (com.baidu.tbadk.widget.richText.f fVar : (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, com.baidu.tbadk.widget.richText.f.class)) {
                spannableStringBuilder.removeSpan(fVar);
            }
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, ForegroundColorSpan.class)) {
                spannableStringBuilder.removeSpan(foregroundColorSpan);
            }
        }
        return spannableStringBuilder;
    }

    public void b(PostData postData) {
        if (this.mImageList == null) {
            this.mImageList = new ArrayList();
        } else {
            this.mImageList.clear();
        }
        if (!com.baidu.tbadk.core.k.aPA().isShowImages()) {
            this.eew.setVisibility(8);
            this.eex.setVisibility(8);
            return;
        }
        TbRichText dia = postData.dia();
        if (dia == null || dia.bkO() == null) {
            this.eew.setVisibility(8);
            this.eex.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dia.bkO().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bh(eet, eet);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bkU());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.eew.setVisibility(8);
            this.eex.setVisibility(8);
            return;
        }
        this.eew.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.eew.getChildCount(); i2++) {
            View childAt = this.eew.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bjE();
                tbImageView.setRadius(dimens);
                tbImageView.oi(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.blj())) {
                        tbImageView.startLoad(tbRichTextImageInfo.blj(), this.aik ? 13 : 14, false);
                        tbImageView.setVisibility(0);
                        i++;
                    } else {
                        tbImageView.setVisibility(8);
                    }
                } else {
                    tbImageView.setVisibility(8);
                }
            }
            i = i;
        }
        if (this.mImageList.size() > 5) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dLj, this.dLj);
            layoutParams.leftMargin = (this.dLj + this.eeB) * 4;
            this.eew.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.eex.setVisibility(0);
            this.eex.setText("+" + (this.mImageList.size() - 5));
            this.eex.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.dLj - ThreadGodReplyLayout.this.eex.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.eex.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.eex.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.eex.setVisibility(8);
    }

    public void c(PostData postData) {
        this.eeA = postData.bkW();
        if (this.eeA == null) {
            this.eev.setVisibility(8);
            return;
        }
        this.eev.setVisibility(0);
        this.eev.setTag(this.eeA);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            an.setViewTextColor(this.ahA, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aXq().lH(R.color.cp_bg_line_g).Q(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aR(this.mRootView);
            aYF();
            aYE();
            this.edr.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.eev.aYi();
        }
    }

    private void aYF() {
        m.a(this.eeu, this.aiq == null ? null : this.aiq.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.eeu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.blg());
            }
            String str = "";
            String str2 = "";
            if (this.aiq != null) {
                str = this.aiq.aSt();
                str2 = this.aiq.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            createConfig.setThreadData(this.aiq);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (this.ahw != null) {
                this.ahw.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahw = onClickListener;
    }
}
