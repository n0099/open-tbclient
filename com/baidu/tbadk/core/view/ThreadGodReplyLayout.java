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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int fdF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener akR;
    private View.OnClickListener akt;
    private TextView aky;
    private boolean alo;
    private by alu;
    private int eIP;
    private AgreeView fcF;
    private TextView fdG;
    private PlayVoiceBntNew fdH;
    private FrameLayout fdI;
    private TextView fdJ;
    private ClickableHeaderImageView fdK;
    private PostData fdL;
    private TbRichTextVoiceInfo fdM;
    private int fdN;
    private final float fdO;
    private View.OnClickListener fdP;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.alu = null;
        this.mSkinType = 3;
        this.fdO = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.akR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fdL != null && ThreadGodReplyLayout.this.fdL.boP() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fdL.boP().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fdL.boP().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fdL.boP().getUserId(), ThreadGodReplyLayout.this.fdL.boP().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fdL.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.akt != null) {
                        ThreadGodReplyLayout.this.akt.onClick(view);
                    }
                }
            }
        };
        this.fdP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.akt != null) {
                    ThreadGodReplyLayout.this.akt.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alu = null;
        this.mSkinType = 3;
        this.fdO = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.akR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fdL != null && ThreadGodReplyLayout.this.fdL.boP() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fdL.boP().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fdL.boP().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fdL.boP().getUserId(), ThreadGodReplyLayout.this.fdL.boP().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fdL.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.akt != null) {
                        ThreadGodReplyLayout.this.akt.onClick(view);
                    }
                }
            }
        };
        this.fdP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.akt != null) {
                    ThreadGodReplyLayout.this.akt.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alu = null;
        this.mSkinType = 3;
        this.fdO = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.akR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fdL != null && ThreadGodReplyLayout.this.fdL.boP() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fdL.boP().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fdL.boP().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fdL.boP().getUserId(), ThreadGodReplyLayout.this.fdL.boP().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fdL.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.akt != null) {
                        ThreadGodReplyLayout.this.akt.onClick(view);
                    }
                }
            }
        };
        this.fdP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.akt != null) {
                    ThreadGodReplyLayout.this.akt.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.fdK = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.fdK.setIsRound(true);
        this.fdK.setClickable(true);
        this.aky = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.aky.setOnClickListener(this.akR);
        this.fcF = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.fcF.setAfterClickListener(this.fdP);
        this.fcF.setAgreeAlone(true);
        this.fdG = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.fdH = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.fdH.setVisibility(8);
        this.fdI = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.fdN = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.eIP = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.fdN * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eIP, this.eIP);
            layoutParams.leftMargin = (this.eIP + this.fdN) * i;
            this.fdI.addView(tbImageView, layoutParams);
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
        this.fdI.setVisibility(8);
        this.fdJ = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bvN() {
        if (this.fdK != null) {
            this.fdK.setPlaceHolder(1);
        }
        int childCount = this.fdI.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fdI.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(by byVar) {
        this.alu = byVar;
        setData(byVar != null ? byVar.bqu() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.boP() == null || postData.boP().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.fdL = postData;
        setVisibility(0);
        a(postData);
        c(a(postData.dPj()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.fdM != null && this.fdM.bJD() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.M_H_X003));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds0));
        }
        if (!bz(this.fdG) && !bz(this.fdI) && !bz(this.fdH)) {
            setVisibility(8);
        }
    }

    private void c(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.fdG.setVisibility(8);
            return;
        }
        this.fdG.setVisibility(0);
        if (!v.a(this.fdO, this.fdG.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.fdG.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.csh().e(new ar("c13348"));
                        ThreadGodReplyLayout.this.fdG.setMaxLines(15);
                        ThreadGodReplyLayout.this.fdG.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.fdG.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.fdG.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.fdG.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.fdG.setText(((Object) ThreadGodReplyLayout.this.fdG.getText().subSequence(0, ThreadGodReplyLayout.this.fdG.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.fdG.getPaint(), (int) this.fdO, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.fdO;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.fdO - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.fdG.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.fdG.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.fdG.setText(spannableStringBuilder);
                this.fdG.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                t.csh().e(new ar("c13347"));
            } else {
                return;
            }
        }
        bvO();
    }

    private boolean bz(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.fdK.setData(postData.boP());
            this.aky.setText(au.cutChineseAndEnglishWithSuffix(postData.boP().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.alu != null) {
                postData.bqI().threadId = this.alu.getTid();
            }
            postData.bqI().threadId = String.valueOf(postData.getTid());
            postData.bqI().objType = 3;
            this.fcF.setData(postData.bqI());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bIC;
        if (tbRichText == null || (bIC = tbRichText.bIC()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bIC.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bIJ());
            } else if (next.getType() == 17) {
                String str = next.bIN().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.blV().isShowImages()) {
            this.fdI.setVisibility(8);
            this.fdJ.setVisibility(8);
            return;
        }
        TbRichText dPj = postData.dPj();
        if (dPj == null || dPj.bIC() == null) {
            this.fdI.setVisibility(8);
            this.fdJ.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dPj.bIC().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bv(fdF, fdF);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bII());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.fdI.setVisibility(8);
            this.fdJ.setVisibility(8);
            return;
        }
        this.fdI.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.fdI.getChildCount(); i2++) {
            View childAt = this.fdI.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bHt();
                tbImageView.setRadius(dimens);
                tbImageView.sY(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bIX())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bIX(), this.alo ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eIP, this.eIP);
            layoutParams.leftMargin = (this.eIP + this.fdN) * 4;
            this.fdI.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.fdJ.setVisibility(0);
            this.fdJ.setText("+" + (this.mImageList.size() - 5));
            this.fdJ.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.eIP - ThreadGodReplyLayout.this.fdJ.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.fdJ.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.fdJ.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.fdJ.setVisibility(8);
    }

    public void c(PostData postData) {
        this.fdM = postData.bIK();
        if (this.fdM == null) {
            this.fdH.setVisibility(8);
            return;
        }
        this.fdH.setVisibility(0);
        this.fdH.setTag(this.fdM);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.aky, R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.mRootView).pA(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            bvO();
            bvN();
            this.fcF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fdH.bvs();
        }
    }

    private void bvO() {
        n.a(this.fdG, this.alu == null ? null : this.alu.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public TextView getGodReplyContent() {
        return this.fdG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bIU());
            }
            String str = "";
            String str2 = "";
            if (this.alu != null) {
                str = this.alu.boT();
                str2 = this.alu.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).oj(intValue).AG(str).AI(str2).iN(true).AJ(arrayList.get(0)).iO(true).s(this.alu).iT(false);
            ImageViewerConfig ez = aVar.ez(getContext());
            ez.getIntent().putExtra("from", this.mFrom);
            ez.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez));
            if (this.akt != null) {
                this.akt.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }
}
