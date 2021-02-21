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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int fkW = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener ajT;
    private TextView ajY;
    private boolean akO;
    private cb akU;
    private View.OnClickListener akr;
    private int eQj;
    private AgreeView fjW;
    private TextView fkX;
    private PlayVoiceBntNew fkY;
    private FrameLayout fkZ;
    private TextView fla;
    private ClickableHeaderImageView flb;
    private PostData flc;
    private TbRichTextVoiceInfo fld;
    private int fle;
    private final float flf;
    private View.OnClickListener flg;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.akU = null;
        this.mSkinType = 3;
        this.flf = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.akr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.flc != null && ThreadGodReplyLayout.this.flc.bnQ() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.flc.bnQ().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.flc.bnQ().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.flc.bnQ().getUserId(), ThreadGodReplyLayout.this.flc.bnQ().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.flc.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ajT != null) {
                        ThreadGodReplyLayout.this.ajT.onClick(view);
                    }
                }
            }
        };
        this.flg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ajT != null) {
                    ThreadGodReplyLayout.this.ajT.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akU = null;
        this.mSkinType = 3;
        this.flf = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.akr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.flc != null && ThreadGodReplyLayout.this.flc.bnQ() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.flc.bnQ().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.flc.bnQ().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.flc.bnQ().getUserId(), ThreadGodReplyLayout.this.flc.bnQ().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.flc.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ajT != null) {
                        ThreadGodReplyLayout.this.ajT.onClick(view);
                    }
                }
            }
        };
        this.flg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ajT != null) {
                    ThreadGodReplyLayout.this.ajT.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akU = null;
        this.mSkinType = 3;
        this.flf = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.akr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.flc != null && ThreadGodReplyLayout.this.flc.bnQ() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.flc.bnQ().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.flc.bnQ().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.flc.bnQ().getUserId(), ThreadGodReplyLayout.this.flc.bnQ().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.flc.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ajT != null) {
                        ThreadGodReplyLayout.this.ajT.onClick(view);
                    }
                }
            }
        };
        this.flg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ajT != null) {
                    ThreadGodReplyLayout.this.ajT.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.flb = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.flb.setIsRound(true);
        this.flb.setClickable(true);
        this.ajY = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.ajY.setOnClickListener(this.akr);
        this.fjW = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.fjW.setAfterClickListener(this.flg);
        this.fjW.setAgreeAlone(true);
        this.fkX = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.fkY = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.fkY.setVisibility(8);
        this.fkZ = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.fle = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.eQj = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.fle * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eQj, this.eQj);
            layoutParams.leftMargin = (this.eQj + this.fle) * i;
            this.fkZ.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            tbImageView.setPlaceHolder(2);
        }
        this.fkZ.setVisibility(8);
        this.fla = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void buJ() {
        if (this.flb != null) {
            this.flb.setPlaceHolder(1);
        }
        int childCount = this.fkZ.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fkZ.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(cb cbVar) {
        this.akU = cbVar;
        setData(cbVar != null ? cbVar.bpv() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.bnQ() == null || postData.bnQ().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.flc = postData;
        setVisibility(0);
        a(postData);
        c(a(postData.dNH()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.fld != null && this.fld.bIx() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.M_H_X003));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds0));
        }
        if (!bE(this.fkX) && !bE(this.fkZ) && !bE(this.fkY)) {
            setVisibility(8);
        }
    }

    private void c(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.fkX.setVisibility(8);
            return;
        }
        this.fkX.setVisibility(0);
        if (!v.a(this.flf, this.fkX.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.fkX.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.csB().e(new ar("c13348"));
                        ThreadGodReplyLayout.this.fkX.setMaxLines(15);
                        ThreadGodReplyLayout.this.fkX.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.fkX.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.fkX.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.fkX.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.fkX.setText(((Object) ThreadGodReplyLayout.this.fkX.getText().subSequence(0, ThreadGodReplyLayout.this.fkX.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.fkX.getPaint(), (int) this.flf, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.flf;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.flf - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.fkX.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.fkX.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.fkX.setText(spannableStringBuilder);
                this.fkX.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                t.csB().e(new ar("c13347"));
            } else {
                return;
            }
        }
        buK();
    }

    private boolean bE(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.flb.setData(postData.bnQ());
            this.ajY.setText(au.cutChineseAndEnglishWithSuffix(postData.bnQ().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.akU != null) {
                postData.bpJ().threadId = this.akU.getTid();
            }
            postData.bpJ().threadId = String.valueOf(postData.getTid());
            postData.bpJ().objType = 3;
            this.fjW.setData(postData.bpJ());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bHz;
        if (tbRichText == null || (bHz = tbRichText.bHz()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bHz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bHG());
            } else if (next.getType() == 17) {
                String str = next.bHK().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.bkT().isShowImages()) {
            this.fkZ.setVisibility(8);
            this.fla.setVisibility(8);
            return;
        }
        TbRichText dNH = postData.dNH();
        if (dNH == null || dNH.bHz() == null) {
            this.fkZ.setVisibility(8);
            this.fla.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dNH.bHz().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bq(fkW, fkW);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bHF());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.fkZ.setVisibility(8);
            this.fla.setVisibility(8);
            return;
        }
        this.fkZ.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.fkZ.getChildCount(); i2++) {
            View childAt = this.fkZ.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bGo();
                tbImageView.setRadius(dimens);
                tbImageView.rI(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bHS())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bHS(), this.akO ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eQj, this.eQj);
            layoutParams.leftMargin = (this.eQj + this.fle) * 4;
            this.fkZ.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.fla.setVisibility(0);
            this.fla.setText("+" + (this.mImageList.size() - 5));
            this.fla.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.eQj - ThreadGodReplyLayout.this.fla.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.fla.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.fla.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.fla.setVisibility(8);
    }

    public void c(PostData postData) {
        this.fld = postData.bHH();
        if (this.fld == null) {
            this.fkY.setVisibility(8);
            return;
        }
        this.fkY.setVisibility(0);
        this.fkY.setTag(this.fld);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.ajY, R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            buK();
            buJ();
            this.fjW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fkY.buo();
        }
    }

    private void buK() {
        m.a(this.fkX, this.akU == null ? null : this.akU.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public TextView getGodReplyContent() {
        return this.fkX;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bHP());
            }
            String str = "";
            String str2 = "";
            if (this.akU != null) {
                str = this.akU.bnU();
                str2 = this.akU.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).mQ(intValue).zJ(str).zL(str2).jg(true).zM(arrayList.get(0)).jh(true).s(this.akU).jm(false);
            ImageViewerConfig eP = aVar.eP(getContext());
            eP.getIntent().putExtra("from", this.mFrom);
            eP.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eP));
            if (this.ajT != null) {
                this.ajT.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }
}
