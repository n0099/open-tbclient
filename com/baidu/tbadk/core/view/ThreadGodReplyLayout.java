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
    private static final int dII = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener afV;
    private TextView afZ;
    private bj agC;
    private View.OnClickListener agt;
    private boolean agw;
    private AgreeView dHF;
    private TextView dIJ;
    private PlayVoiceBntNew dIK;
    private FrameLayout dIL;
    private TextView dIM;
    private ClickableHeaderImageView dIN;
    private PostData dIO;
    private TbRichTextVoiceInfo dIP;
    private int dIQ;
    private final float dIR;
    private View.OnClickListener dIS;
    private int dqF;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.agC = null;
        this.mSkinType = 3;
        this.dIR = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.agt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dIO != null && ThreadGodReplyLayout.this.dIO.aKC() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dIO.aKC().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dIO.aKC().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dIO.aKC().getUserId(), ThreadGodReplyLayout.this.dIO.aKC().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dIO.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.afV != null) {
                        ThreadGodReplyLayout.this.afV.onClick(view);
                    }
                }
            }
        };
        this.dIS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.afV != null) {
                    ThreadGodReplyLayout.this.afV.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agC = null;
        this.mSkinType = 3;
        this.dIR = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.agt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dIO != null && ThreadGodReplyLayout.this.dIO.aKC() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dIO.aKC().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dIO.aKC().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dIO.aKC().getUserId(), ThreadGodReplyLayout.this.dIO.aKC().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dIO.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.afV != null) {
                        ThreadGodReplyLayout.this.afV.onClick(view);
                    }
                }
            }
        };
        this.dIS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.afV != null) {
                    ThreadGodReplyLayout.this.afV.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agC = null;
        this.mSkinType = 3;
        this.dIR = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.agt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dIO != null && ThreadGodReplyLayout.this.dIO.aKC() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dIO.aKC().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dIO.aKC().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dIO.aKC().getUserId(), ThreadGodReplyLayout.this.dIO.aKC().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dIO.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.afV != null) {
                        ThreadGodReplyLayout.this.afV.onClick(view);
                    }
                }
            }
        };
        this.dIS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.afV != null) {
                    ThreadGodReplyLayout.this.afV.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.dIN = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.dIN.setIsRound(true);
        this.dIN.setClickable(true);
        this.afZ = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.afZ.setOnClickListener(this.agt);
        this.dHF = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.dHF.setAfterClickListener(this.dIS);
        this.dHF.setAgreeAlone(true);
        this.dIJ = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.dIK = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.dIK.setVisibility(8);
        this.dIL = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.dIQ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.dqF = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.dIQ * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dqF, this.dqF);
            layoutParams.leftMargin = (this.dqF + this.dIQ) * i;
            this.dIL.addView(tbImageView, layoutParams);
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
        this.dIL.setVisibility(8);
        this.dIM = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aQC() {
        if (this.dIN != null) {
            this.dIN.setPlaceHolder(1);
        }
        int childCount = this.dIL.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dIL.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        this.agC = bjVar;
        setData(bjVar != null ? bjVar.aMc() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aKC() == null || postData.aKC().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.dIO = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cWq()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.dIP != null && this.dIP.bdd() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!aZ(this.dIJ) && !aZ(this.dIL) && !aZ(this.dIK)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.dIJ.setVisibility(8);
            return;
        }
        this.dIJ.setVisibility(0);
        if (!v.a(this.dIR, this.dIJ.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.dIJ.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        r.bEW().e(new an("c13348"));
                        ThreadGodReplyLayout.this.dIJ.setMaxLines(15);
                        ThreadGodReplyLayout.this.dIJ.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.dIJ.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.dIJ.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.dIJ.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.dIJ.setText(((Object) ThreadGodReplyLayout.this.dIJ.getText().subSequence(0, ThreadGodReplyLayout.this.dIJ.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.dIJ.getPaint(), (int) this.dIR, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.dIR;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.dIR - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.dIJ.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.dIJ.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.dIJ.setText(spannableStringBuilder);
                this.dIJ.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                r.bEW().e(new an("c13347"));
            } else {
                return;
            }
        }
        aQD();
    }

    private boolean aZ(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.dIN.setData(postData.aKC());
            this.afZ.setText(aq.cutChineseAndEnglishWithSuffix(postData.aKC().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.agC != null) {
                postData.aMq().threadId = this.agC.getTid();
            }
            postData.aMq().threadId = String.valueOf(postData.getTid());
            postData.aMq().objType = 3;
            this.dHF.setData(postData.aMq());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bcf;
        if (tbRichText == null || (bcf = tbRichText.bcf()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bcf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bcm());
            } else if (next.getType() == 17) {
                String str = next.bcq().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.aIc().isShowImages()) {
            this.dIL.setVisibility(8);
            this.dIM.setVisibility(8);
            return;
        }
        TbRichText cWq = postData.cWq();
        if (cWq == null || cWq.bcf() == null) {
            this.dIL.setVisibility(8);
            this.dIM.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cWq.bcf().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aZ(dII, dII);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bcl());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.dIL.setVisibility(8);
            this.dIM.setVisibility(8);
            return;
        }
        this.dIL.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.dIL.getChildCount(); i2++) {
            View childAt = this.dIL.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bbf();
                tbImageView.setRadius(dimens);
                tbImageView.ni(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bcy())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bcy(), this.agw ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dqF, this.dqF);
            layoutParams.leftMargin = (this.dqF + this.dIQ) * 4;
            this.dIL.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.dIM.setVisibility(0);
            this.dIM.setText("+" + (this.mImageList.size() - 5));
            this.dIM.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.dqF - ThreadGodReplyLayout.this.dIM.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.dIM.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.dIM.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.dIM.setVisibility(8);
    }

    public void c(PostData postData) {
        this.dIP = postData.bcn();
        if (this.dIP == null) {
            this.dIK.setVisibility(8);
            return;
        }
        this.dIK.setVisibility(0);
        this.dIK.setTag(this.dIP);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.afZ, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aPr().kM(R.color.cp_bg_line_g).P(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aR(this.mRootView);
            aQD();
            aQC();
            this.dHF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.dIK.ckM();
        }
    }

    private void aQD() {
        com.baidu.tieba.card.l.a(this.dIJ, this.agC == null ? null : this.agC.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.dIJ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bcv());
            }
            String str = "";
            String str2 = "";
            if (this.agC != null) {
                str = this.agC.aKH();
                str2 = this.agC.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            createConfig.setThreadData(this.agC);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (this.afV != null) {
                this.afV.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afV = onClickListener;
    }
}
