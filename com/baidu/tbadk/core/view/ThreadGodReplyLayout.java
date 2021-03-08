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
    private static final int fmw = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener alK;
    private View.OnClickListener alm;
    private TextView alr;
    private boolean amh;
    private cb amn;
    private int eRK;
    private AgreeView flv;
    private TextView fmA;
    private ClickableHeaderImageView fmB;
    private PostData fmC;
    private TbRichTextVoiceInfo fmD;
    private int fmE;
    private final float fmF;
    private View.OnClickListener fmG;
    private TextView fmx;
    private PlayVoiceBntNew fmy;
    private FrameLayout fmz;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.amn = null;
        this.mSkinType = 3;
        this.fmF = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.alK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fmC != null && ThreadGodReplyLayout.this.fmC.bnS() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fmC.bnS().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fmC.bnS().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fmC.bnS().getUserId(), ThreadGodReplyLayout.this.fmC.bnS().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fmC.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.alm != null) {
                        ThreadGodReplyLayout.this.alm.onClick(view);
                    }
                }
            }
        };
        this.fmG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.alm != null) {
                    ThreadGodReplyLayout.this.alm.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amn = null;
        this.mSkinType = 3;
        this.fmF = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.alK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fmC != null && ThreadGodReplyLayout.this.fmC.bnS() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fmC.bnS().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fmC.bnS().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fmC.bnS().getUserId(), ThreadGodReplyLayout.this.fmC.bnS().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fmC.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.alm != null) {
                        ThreadGodReplyLayout.this.alm.onClick(view);
                    }
                }
            }
        };
        this.fmG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.alm != null) {
                    ThreadGodReplyLayout.this.alm.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amn = null;
        this.mSkinType = 3;
        this.fmF = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.alK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fmC != null && ThreadGodReplyLayout.this.fmC.bnS() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fmC.bnS().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fmC.bnS().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fmC.bnS().getUserId(), ThreadGodReplyLayout.this.fmC.bnS().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fmC.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.alm != null) {
                        ThreadGodReplyLayout.this.alm.onClick(view);
                    }
                }
            }
        };
        this.fmG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.alm != null) {
                    ThreadGodReplyLayout.this.alm.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.fmB = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.fmB.setIsRound(true);
        this.fmB.setClickable(true);
        this.alr = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.alr.setOnClickListener(this.alK);
        this.flv = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.flv.setAfterClickListener(this.fmG);
        this.flv.setAgreeAlone(true);
        this.fmx = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.fmy = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.fmy.setVisibility(8);
        this.fmz = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.fmE = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.eRK = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.fmE * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eRK, this.eRK);
            layoutParams.leftMargin = (this.eRK + this.fmE) * i;
            this.fmz.addView(tbImageView, layoutParams);
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
        this.fmz.setVisibility(8);
        this.fmA = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void buM() {
        if (this.fmB != null) {
            this.fmB.setPlaceHolder(1);
        }
        int childCount = this.fmz.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fmz.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(cb cbVar) {
        this.amn = cbVar;
        setData(cbVar != null ? cbVar.bpx() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.bnS() == null || postData.bnS().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.fmC = postData;
        setVisibility(0);
        a(postData);
        c(a(postData.dNQ()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.fmD != null && this.fmD.bIB() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.M_H_X003));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds0));
        }
        if (!bE(this.fmx) && !bE(this.fmz) && !bE(this.fmy)) {
            setVisibility(8);
        }
    }

    private void c(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.fmx.setVisibility(8);
            return;
        }
        this.fmx.setVisibility(0);
        if (!v.a(this.fmF, this.fmx.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.fmx.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.csH().e(new ar("c13348"));
                        ThreadGodReplyLayout.this.fmx.setMaxLines(15);
                        ThreadGodReplyLayout.this.fmx.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.fmx.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.fmx.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.fmx.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.fmx.setText(((Object) ThreadGodReplyLayout.this.fmx.getText().subSequence(0, ThreadGodReplyLayout.this.fmx.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.fmx.getPaint(), (int) this.fmF, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.fmF;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.fmF - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.fmx.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.fmx.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.fmx.setText(spannableStringBuilder);
                this.fmx.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                t.csH().e(new ar("c13347"));
            } else {
                return;
            }
        }
        buN();
    }

    private boolean bE(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.fmB.setData(postData.bnS());
            this.alr.setText(au.cutChineseAndEnglishWithSuffix(postData.bnS().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.amn != null) {
                postData.bpL().threadId = this.amn.getTid();
            }
            postData.bpL().threadId = String.valueOf(postData.getTid());
            postData.bpL().objType = 3;
            this.flv.setData(postData.bpL());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bHD;
        if (tbRichText == null || (bHD = tbRichText.bHD()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bHD.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bHK());
            } else if (next.getType() == 17) {
                String str = next.bHO().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.bkV().isShowImages()) {
            this.fmz.setVisibility(8);
            this.fmA.setVisibility(8);
            return;
        }
        TbRichText dNQ = postData.dNQ();
        if (dNQ == null || dNQ.bHD() == null) {
            this.fmz.setVisibility(8);
            this.fmA.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dNQ.bHD().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bq(fmw, fmw);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bHJ());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.fmz.setVisibility(8);
            this.fmA.setVisibility(8);
            return;
        }
        this.fmz.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.fmz.getChildCount(); i2++) {
            View childAt = this.fmz.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bGs();
                tbImageView.setRadius(dimens);
                tbImageView.rK(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bHW())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bHW(), this.amh ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eRK, this.eRK);
            layoutParams.leftMargin = (this.eRK + this.fmE) * 4;
            this.fmz.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.fmA.setVisibility(0);
            this.fmA.setText("+" + (this.mImageList.size() - 5));
            this.fmA.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.eRK - ThreadGodReplyLayout.this.fmA.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.fmA.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.fmA.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.fmA.setVisibility(8);
    }

    public void c(PostData postData) {
        this.fmD = postData.bHL();
        if (this.fmD == null) {
            this.fmy.setVisibility(8);
            return;
        }
        this.fmy.setVisibility(0);
        this.fmy.setTag(this.fmD);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.alr, R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).oh(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            buN();
            buM();
            this.flv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fmy.bur();
        }
    }

    private void buN() {
        m.a(this.fmx, this.amn == null ? null : this.amn.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public TextView getGodReplyContent() {
        return this.fmx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bHT());
            }
            String str = "";
            String str2 = "";
            if (this.amn != null) {
                str = this.amn.bnW();
                str2 = this.amn.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).mR(intValue).zQ(str).zS(str2).jg(true).zT(arrayList.get(0)).jh(true).s(this.amn).jm(false);
            ImageViewerConfig eO = aVar.eO(getContext());
            eO.getIntent().putExtra("from", this.mFrom);
            eO.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO));
            if (this.alm != null) {
                this.alm.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }
}
