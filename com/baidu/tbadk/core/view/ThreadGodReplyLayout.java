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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int diL = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener NH;
    private boolean NK;
    private bj NR;
    private View.OnClickListener Ni;
    private TextView Nm;
    private int cRu;
    private AgreeView dhG;
    private TextView diM;
    private PlayVoiceBntNew diN;
    private FrameLayout diO;
    private TextView diP;
    private ClickableHeaderImageView diQ;
    private PostData diR;
    private TbRichTextVoiceInfo diS;
    private int diT;
    private final float diU;
    private View.OnClickListener diV;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.NR = null;
        this.mSkinType = 3;
        this.diU = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.diR != null && ThreadGodReplyLayout.this.diR.aCr() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.diR.aCr().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.diR.aCr().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.diR.aCr().getUserId(), ThreadGodReplyLayout.this.diR.aCr().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.diR.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Ni != null) {
                        ThreadGodReplyLayout.this.Ni.onClick(view);
                    }
                }
            }
        };
        this.diV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Ni != null) {
                    ThreadGodReplyLayout.this.Ni.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NR = null;
        this.mSkinType = 3;
        this.diU = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.diR != null && ThreadGodReplyLayout.this.diR.aCr() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.diR.aCr().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.diR.aCr().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.diR.aCr().getUserId(), ThreadGodReplyLayout.this.diR.aCr().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.diR.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Ni != null) {
                        ThreadGodReplyLayout.this.Ni.onClick(view);
                    }
                }
            }
        };
        this.diV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Ni != null) {
                    ThreadGodReplyLayout.this.Ni.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NR = null;
        this.mSkinType = 3;
        this.diU = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.diR != null && ThreadGodReplyLayout.this.diR.aCr() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.diR.aCr().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.diR.aCr().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.diR.aCr().getUserId(), ThreadGodReplyLayout.this.diR.aCr().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.diR.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Ni != null) {
                        ThreadGodReplyLayout.this.Ni.onClick(view);
                    }
                }
            }
        };
        this.diV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Ni != null) {
                    ThreadGodReplyLayout.this.Ni.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.diQ = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.diQ.setIsRound(true);
        this.diQ.setClickable(true);
        this.Nm = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.Nm.setOnClickListener(this.NH);
        this.dhG = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.dhG.setAfterClickListener(this.diV);
        this.dhG.setAgreeAlone(true);
        this.diM = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.diN = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.diN.setVisibility(8);
        this.diO = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.diT = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.cRu = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.diT * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.cRu, this.cRu);
            layoutParams.leftMargin = (this.cRu + this.diT) * i;
            this.diO.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            tbImageView.setPlaceHolder(2);
        }
        this.diO.setVisibility(8);
        this.diP = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.NK = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aIj() {
        if (this.diQ != null) {
            this.diQ.setPlaceHolder(1);
        }
        int childCount = this.diO.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.diO.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        this.NR = bjVar;
        setData(bjVar != null ? bjVar.aDQ() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aCr() == null || postData.aCr().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.diR = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cLx()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.diS != null && this.diS.aUV() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!aY(this.diM) && !aY(this.diO) && !aY(this.diN)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.diM.setVisibility(8);
            return;
        }
        this.diM.setVisibility(0);
        if (!v.a(this.diU, this.diM.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.diM.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        r.bvm().e(new an("c13348"));
                        ThreadGodReplyLayout.this.diM.setMaxLines(15);
                        ThreadGodReplyLayout.this.diM.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.diM.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.diM.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.diM.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.diM.setText(((Object) ThreadGodReplyLayout.this.diM.getText().subSequence(0, ThreadGodReplyLayout.this.diM.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.diM.getPaint(), (int) this.diU, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.diU;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.diU - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.diM.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.diM.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.diM.setText(spannableStringBuilder);
                this.diM.setOnTouchListener(new com.baidu.tieba.view.h(spannableStringBuilder));
                r.bvm().e(new an("c13347"));
            } else {
                return;
            }
        }
        aIk();
    }

    private boolean aY(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.diQ.setData(postData.aCr());
            this.Nm.setText(aq.cutChineseAndEnglishWithSuffix(postData.aCr().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.NR != null) {
                postData.aEe().threadId = this.NR.getTid();
            }
            postData.aEe().threadId = String.valueOf(postData.getTid());
            postData.aEe().objType = 3;
            this.dhG.setData(postData.aEe());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> aTX;
        if (tbRichText == null || (aTX = tbRichText.aTX()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = aTX.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.aUe());
            } else if (next.getType() == 17) {
                String str = next.aUi().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.azR().isShowImages()) {
            this.diO.setVisibility(8);
            this.diP.setVisibility(8);
            return;
        }
        TbRichText cLx = postData.cLx();
        if (cLx == null || cLx.aTX() == null) {
            this.diO.setVisibility(8);
            this.diP.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cLx.aTX().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aV(diL, diL);
                if (next.getType() == 8) {
                    this.mImageList.add(next.aUd());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.diO.setVisibility(8);
            this.diP.setVisibility(8);
            return;
        }
        this.diO.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.diO.getChildCount(); i2++) {
            View childAt = this.diO.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.aSX();
                tbImageView.setRadius(dimens);
                tbImageView.mW(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.aUq())) {
                        tbImageView.startLoad(tbRichTextImageInfo.aUq(), this.NK ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.cRu, this.cRu);
            layoutParams.leftMargin = (this.cRu + this.diT) * 4;
            this.diO.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.diP.setVisibility(0);
            this.diP.setText("+" + (this.mImageList.size() - 5));
            this.diP.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.cRu - ThreadGodReplyLayout.this.diP.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.diP.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.diP.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.diP.setVisibility(8);
    }

    public void c(PostData postData) {
        this.diS = postData.aUf();
        if (this.diS == null) {
            this.diN.setVisibility(8);
            return;
        }
        this.diN.setVisibility(0);
        this.diN.setTag(this.diS);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.Nm, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aHf().kC(R.color.cp_bg_line_g).af(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aQ(this.mRootView);
            aIk();
            aIj();
            this.dhG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.diN.can();
        }
    }

    private void aIk() {
        com.baidu.tieba.card.l.a(this.diM, this.NR == null ? null : this.NR.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.diM;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.aUn());
            }
            String str = "";
            String str2 = "";
            if (this.NR != null) {
                str = this.NR.aCw();
                str2 = this.NR.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            createConfig.setThreadData(this.NR);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (this.Ni != null) {
                this.Ni.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Ni = onClickListener;
    }
}
