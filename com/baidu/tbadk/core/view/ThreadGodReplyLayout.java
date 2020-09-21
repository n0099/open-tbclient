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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes20.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int ewG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener aiW;
    private boolean ajR;
    private bw ajX;
    private TextView ajb;
    private View.OnClickListener ajv;
    private int edd;
    private AgreeView evE;
    private TextView ewH;
    private PlayVoiceBntNew ewI;
    private FrameLayout ewJ;
    private TextView ewK;
    private ClickableHeaderImageView ewL;
    private PostData ewM;
    private TbRichTextVoiceInfo ewN;
    private int ewO;
    private final float ewP;
    private View.OnClickListener ewQ;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.ajX = null;
        this.mSkinType = 3;
        this.ewP = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ewM != null && ThreadGodReplyLayout.this.ewM.bfy() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.ewM.bfy().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.ewM.bfy().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.ewM.bfy().getUserId(), ThreadGodReplyLayout.this.ewM.bfy().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.ewM.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aiW != null) {
                        ThreadGodReplyLayout.this.aiW.onClick(view);
                    }
                }
            }
        };
        this.ewQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aiW != null) {
                    ThreadGodReplyLayout.this.aiW.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajX = null;
        this.mSkinType = 3;
        this.ewP = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ewM != null && ThreadGodReplyLayout.this.ewM.bfy() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.ewM.bfy().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.ewM.bfy().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.ewM.bfy().getUserId(), ThreadGodReplyLayout.this.ewM.bfy().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.ewM.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aiW != null) {
                        ThreadGodReplyLayout.this.aiW.onClick(view);
                    }
                }
            }
        };
        this.ewQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aiW != null) {
                    ThreadGodReplyLayout.this.aiW.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajX = null;
        this.mSkinType = 3;
        this.ewP = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ewM != null && ThreadGodReplyLayout.this.ewM.bfy() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.ewM.bfy().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.ewM.bfy().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.ewM.bfy().getUserId(), ThreadGodReplyLayout.this.ewM.bfy().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.ewM.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aiW != null) {
                        ThreadGodReplyLayout.this.aiW.onClick(view);
                    }
                }
            }
        };
        this.ewQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aiW != null) {
                    ThreadGodReplyLayout.this.aiW.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.ewL = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.ewL.setIsRound(true);
        this.ewL.setClickable(true);
        this.ajb = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.ajb.setOnClickListener(this.ajv);
        this.evE = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.evE.setAfterClickListener(this.ewQ);
        this.evE.setAgreeAlone(true);
        this.ewH = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.ewI = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.ewI.setVisibility(8);
        this.ewJ = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.ewO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.edd = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.ewO * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.edd, this.edd);
            layoutParams.leftMargin = (this.edd + this.ewO) * i;
            this.ewJ.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            tbImageView.setPlaceHolder(2);
        }
        this.ewJ.setVisibility(8);
        this.ewK = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void blU() {
        if (this.ewL != null) {
            this.ewL.setPlaceHolder(1);
        }
        int childCount = this.ewJ.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ewJ.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bw bwVar) {
        this.ajX = bwVar;
        setData(bwVar != null ? bwVar.bhb() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.bfy() == null || postData.bfy().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.ewM = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.dAF()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.ewN != null && this.ewN.bzI() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!bk(this.ewH) && !bk(this.ewJ) && !bk(this.ewI)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.ewH.setVisibility(8);
            return;
        }
        this.ewH.setVisibility(0);
        if (!v.a(this.ewP, this.ewH.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.ewH.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        s.cfn().e(new aq("c13348"));
                        ThreadGodReplyLayout.this.ewH.setMaxLines(15);
                        ThreadGodReplyLayout.this.ewH.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.ewH.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.ewH.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.ewH.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.ewH.setText(((Object) ThreadGodReplyLayout.this.ewH.getText().subSequence(0, ThreadGodReplyLayout.this.ewH.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.ewH.getPaint(), (int) this.ewP, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.ewP;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.ewP - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.ewH.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.ewH.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.ewH.setText(spannableStringBuilder);
                this.ewH.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                s.cfn().e(new aq("c13347"));
            } else {
                return;
            }
        }
        blV();
    }

    private boolean bk(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.ewL.setData(postData.bfy());
            this.ajb.setText(at.cutChineseAndEnglishWithSuffix(postData.bfy().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.ajX != null) {
                postData.bhp().threadId = this.ajX.getTid();
            }
            postData.bhp().threadId = String.valueOf(postData.getTid());
            postData.bhp().objType = 3;
            this.evE.setData(postData.bhp());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> byG;
        if (tbRichText == null || (byG = tbRichText.byG()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = byG.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.byN());
            } else if (next.getType() == 17) {
                String str = next.byR().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.bcG().isShowImages()) {
            this.ewJ.setVisibility(8);
            this.ewK.setVisibility(8);
            return;
        }
        TbRichText dAF = postData.dAF();
        if (dAF == null || dAF.byG() == null) {
            this.ewJ.setVisibility(8);
            this.ewK.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dAF.byG().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bt(ewG, ewG);
                if (next.getType() == 8) {
                    this.mImageList.add(next.byM());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.ewJ.setVisibility(8);
            this.ewK.setVisibility(8);
            return;
        }
        this.ewJ.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.ewJ.getChildCount(); i2++) {
            View childAt = this.ewJ.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bxw();
                tbImageView.setRadius(dimens);
                tbImageView.re(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bzc())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bzc(), this.ajR ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.edd, this.edd);
            layoutParams.leftMargin = (this.edd + this.ewO) * 4;
            this.ewJ.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.ewK.setVisibility(0);
            this.ewK.setText("+" + (this.mImageList.size() - 5));
            this.ewK.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.edd - ThreadGodReplyLayout.this.ewK.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.ewK.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.ewK.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.ewK.setVisibility(8);
    }

    public void c(PostData postData) {
        this.ewN = postData.byO();
        if (this.ewN == null) {
            this.ewI.setVisibility(8);
            return;
        }
        this.ewI.setVisibility(0);
        this.ewI.setTag(this.ewN);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.ajb, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bkL().or(R.color.cp_bg_line_g).V(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bb(this.mRootView);
            blV();
            blU();
            this.evE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.ewI.changeSkin();
        }
    }

    private void blV() {
        m.a(this.ewH, this.ajX == null ? null : this.ajX.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.ewH;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.byZ());
            }
            String str = "";
            String str2 = "";
            if (this.ajX != null) {
                str = this.ajX.bfC();
                str2 = this.ajX.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).mX(intValue).zl(str).zn(str2).hF(true).zo(arrayList.get(0)).hG(true).s(this.ajX).hL(false);
            ImageViewerConfig dO = aVar.dO(getContext());
            dO.getIntent().putExtra("from", this.mFrom);
            dO.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO));
            if (this.aiW != null) {
                this.aiW.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiW = onClickListener;
    }
}
