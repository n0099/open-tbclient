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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int fiF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener akC;
    private boolean akY;
    private View.OnClickListener ake;
    private TextView akj;
    private bz ale;
    private int eNX;
    private AgreeView fhD;
    private TextView fiG;
    private PlayVoiceBntNew fiH;
    private FrameLayout fiI;
    private TextView fiJ;
    private ClickableHeaderImageView fiK;
    private PostData fiL;
    private TbRichTextVoiceInfo fiM;
    private int fiN;
    private final float fiO;
    private View.OnClickListener fiP;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.ale = null;
        this.mSkinType = 3;
        this.fiO = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.akC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fiL != null && ThreadGodReplyLayout.this.fiL.bnx() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fiL.bnx().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fiL.bnx().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fiL.bnx().getUserId(), ThreadGodReplyLayout.this.fiL.bnx().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fiL.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ake != null) {
                        ThreadGodReplyLayout.this.ake.onClick(view);
                    }
                }
            }
        };
        this.fiP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ake != null) {
                    ThreadGodReplyLayout.this.ake.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ale = null;
        this.mSkinType = 3;
        this.fiO = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.akC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fiL != null && ThreadGodReplyLayout.this.fiL.bnx() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fiL.bnx().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fiL.bnx().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fiL.bnx().getUserId(), ThreadGodReplyLayout.this.fiL.bnx().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fiL.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ake != null) {
                        ThreadGodReplyLayout.this.ake.onClick(view);
                    }
                }
            }
        };
        this.fiP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ake != null) {
                    ThreadGodReplyLayout.this.ake.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ale = null;
        this.mSkinType = 3;
        this.fiO = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.akC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fiL != null && ThreadGodReplyLayout.this.fiL.bnx() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fiL.bnx().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fiL.bnx().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fiL.bnx().getUserId(), ThreadGodReplyLayout.this.fiL.bnx().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fiL.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ake != null) {
                        ThreadGodReplyLayout.this.ake.onClick(view);
                    }
                }
            }
        };
        this.fiP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ake != null) {
                    ThreadGodReplyLayout.this.ake.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.fiK = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.fiK.setIsRound(true);
        this.fiK.setClickable(true);
        this.akj = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.akj.setOnClickListener(this.akC);
        this.fhD = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.fhD.setAfterClickListener(this.fiP);
        this.fhD.setAgreeAlone(true);
        this.fiG = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.fiH = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.fiH.setVisibility(8);
        this.fiI = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.fiN = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.eNX = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.fiN * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eNX, this.eNX);
            layoutParams.leftMargin = (this.eNX + this.fiN) * i;
            this.fiI.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ao.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            tbImageView.setPlaceHolder(2);
        }
        this.fiI.setVisibility(8);
        this.fiJ = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bup() {
        if (this.fiK != null) {
            this.fiK.setPlaceHolder(1);
        }
        int childCount = this.fiI.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fiI.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bz bzVar) {
        this.ale = bzVar;
        setData(bzVar != null ? bzVar.bpd() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.bnx() == null || postData.bnx().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.fiL = postData;
        setVisibility(0);
        a(postData);
        c(a(postData.dLo()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.fiM != null && this.fiM.bIe() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.M_H_X003));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds0));
        }
        if (!bI(this.fiG) && !bI(this.fiI) && !bI(this.fiH)) {
            setVisibility(8);
        }
    }

    private void c(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.fiG.setVisibility(8);
            return;
        }
        this.fiG.setVisibility(0);
        if (!v.a(this.fiO, this.fiG.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.fiG.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        s.crj().e(new aq("c13348"));
                        ThreadGodReplyLayout.this.fiG.setMaxLines(15);
                        ThreadGodReplyLayout.this.fiG.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.fiG.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.fiG.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.fiG.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.fiG.setText(((Object) ThreadGodReplyLayout.this.fiG.getText().subSequence(0, ThreadGodReplyLayout.this.fiG.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.fiG.getPaint(), (int) this.fiO, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.fiO;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.fiO - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.fiG.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.fiG.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.fiG.setText(spannableStringBuilder);
                this.fiG.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                s.crj().e(new aq("c13347"));
            } else {
                return;
            }
        }
        buq();
    }

    private boolean bI(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.fiK.setData(postData.bnx());
            this.akj.setText(at.cutChineseAndEnglishWithSuffix(postData.bnx().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.ale != null) {
                postData.bpr().threadId = this.ale.getTid();
            }
            postData.bpr().threadId = String.valueOf(postData.getTid());
            postData.bpr().objType = 3;
            this.fhD.setData(postData.bpr());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bHf;
        if (tbRichText == null || (bHf = tbRichText.bHf()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bHf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bHm());
            } else if (next.getType() == 17) {
                String str = next.bHq().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.bkB().isShowImages()) {
            this.fiI.setVisibility(8);
            this.fiJ.setVisibility(8);
            return;
        }
        TbRichText dLo = postData.dLo();
        if (dLo == null || dLo.bHf() == null) {
            this.fiI.setVisibility(8);
            this.fiJ.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dLo.bHf().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bt(fiF, fiF);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bHl());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.fiI.setVisibility(8);
            this.fiJ.setVisibility(8);
            return;
        }
        this.fiI.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.fiI.getChildCount(); i2++) {
            View childAt = this.fiI.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bFU();
                tbImageView.setRadius(dimens);
                tbImageView.rD(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bHy())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bHy(), this.akY ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eNX, this.eNX);
            layoutParams.leftMargin = (this.eNX + this.fiN) * 4;
            this.fiI.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.fiJ.setVisibility(0);
            this.fiJ.setText("+" + (this.mImageList.size() - 5));
            this.fiJ.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.eNX - ThreadGodReplyLayout.this.fiJ.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.fiJ.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.fiJ.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.fiJ.setVisibility(8);
    }

    public void c(PostData postData) {
        this.fiM = postData.bHn();
        if (this.fiM == null) {
            this.fiH.setVisibility(8);
            return;
        }
        this.fiH.setVisibility(0);
        this.fiH.setTag(this.fiM);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setViewTextColor(this.akj, R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.mRootView).od(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            buq();
            bup();
            this.fhD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fiH.btU();
        }
    }

    private void buq() {
        m.a(this.fiG, this.ale == null ? null : this.ale.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public TextView getGodReplyContent() {
        return this.fiG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bHv());
            }
            String str = "";
            String str2 = "";
            if (this.ale != null) {
                str = this.ale.bnB();
                str2 = this.ale.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).mN(intValue).zs(str).zu(str2).je(true).zv(arrayList.get(0)).jf(true).s(this.ale).jk(false);
            ImageViewerConfig eQ = aVar.eQ(getContext());
            eQ.getIntent().putExtra("from", this.mFrom);
            eQ.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ));
            if (this.ake != null) {
                this.ake.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ake = onClickListener;
    }
}
