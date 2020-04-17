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
    private static final int dIE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener afS;
    private TextView afW;
    private View.OnClickListener agq;
    private boolean agt;
    private bj agz;
    private AgreeView dHB;
    private TextView dIF;
    private PlayVoiceBntNew dIG;
    private FrameLayout dIH;
    private TextView dII;
    private ClickableHeaderImageView dIJ;
    private PostData dIK;
    private TbRichTextVoiceInfo dIL;
    private int dIM;
    private final float dIN;
    private View.OnClickListener dIO;
    private int dqB;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.agz = null;
        this.mSkinType = 3;
        this.dIN = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.agq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dIK != null && ThreadGodReplyLayout.this.dIK.aKE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dIK.aKE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dIK.aKE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dIK.aKE().getUserId(), ThreadGodReplyLayout.this.dIK.aKE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dIK.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.afS != null) {
                        ThreadGodReplyLayout.this.afS.onClick(view);
                    }
                }
            }
        };
        this.dIO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.afS != null) {
                    ThreadGodReplyLayout.this.afS.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agz = null;
        this.mSkinType = 3;
        this.dIN = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.agq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dIK != null && ThreadGodReplyLayout.this.dIK.aKE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dIK.aKE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dIK.aKE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dIK.aKE().getUserId(), ThreadGodReplyLayout.this.dIK.aKE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dIK.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.afS != null) {
                        ThreadGodReplyLayout.this.afS.onClick(view);
                    }
                }
            }
        };
        this.dIO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.afS != null) {
                    ThreadGodReplyLayout.this.afS.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agz = null;
        this.mSkinType = 3;
        this.dIN = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.agq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dIK != null && ThreadGodReplyLayout.this.dIK.aKE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dIK.aKE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dIK.aKE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dIK.aKE().getUserId(), ThreadGodReplyLayout.this.dIK.aKE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dIK.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.afS != null) {
                        ThreadGodReplyLayout.this.afS.onClick(view);
                    }
                }
            }
        };
        this.dIO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.afS != null) {
                    ThreadGodReplyLayout.this.afS.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.dIJ = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.dIJ.setIsRound(true);
        this.dIJ.setClickable(true);
        this.afW = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.afW.setOnClickListener(this.agq);
        this.dHB = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.dHB.setAfterClickListener(this.dIO);
        this.dHB.setAgreeAlone(true);
        this.dIF = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.dIG = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.dIG.setVisibility(8);
        this.dIH = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.dIM = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.dqB = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.dIM * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dqB, this.dqB);
            layoutParams.leftMargin = (this.dqB + this.dIM) * i;
            this.dIH.addView(tbImageView, layoutParams);
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
        this.dIH.setVisibility(8);
        this.dII = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.agt = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aQF() {
        if (this.dIJ != null) {
            this.dIJ.setPlaceHolder(1);
        }
        int childCount = this.dIH.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dIH.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        this.agz = bjVar;
        setData(bjVar != null ? bjVar.aMe() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aKE() == null || postData.aKE().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.dIK = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cWt()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.dIL != null && this.dIL.bdf() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!aZ(this.dIF) && !aZ(this.dIH) && !aZ(this.dIG)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.dIF.setVisibility(8);
            return;
        }
        this.dIF.setVisibility(0);
        if (!v.a(this.dIN, this.dIF.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.dIF.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        r.bEY().e(new an("c13348"));
                        ThreadGodReplyLayout.this.dIF.setMaxLines(15);
                        ThreadGodReplyLayout.this.dIF.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.dIF.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.dIF.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.dIF.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.dIF.setText(((Object) ThreadGodReplyLayout.this.dIF.getText().subSequence(0, ThreadGodReplyLayout.this.dIF.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.dIF.getPaint(), (int) this.dIN, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.dIN;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.dIN - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.dIF.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.dIF.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.dIF.setText(spannableStringBuilder);
                this.dIF.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                r.bEY().e(new an("c13347"));
            } else {
                return;
            }
        }
        aQG();
    }

    private boolean aZ(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.dIJ.setData(postData.aKE());
            this.afW.setText(aq.cutChineseAndEnglishWithSuffix(postData.aKE().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.agz != null) {
                postData.aMs().threadId = this.agz.getTid();
            }
            postData.aMs().threadId = String.valueOf(postData.getTid());
            postData.aMs().objType = 3;
            this.dHB.setData(postData.aMs());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bch;
        if (tbRichText == null || (bch = tbRichText.bch()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bch.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bco());
            } else if (next.getType() == 17) {
                String str = next.bcs().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.aIe().isShowImages()) {
            this.dIH.setVisibility(8);
            this.dII.setVisibility(8);
            return;
        }
        TbRichText cWt = postData.cWt();
        if (cWt == null || cWt.bch() == null) {
            this.dIH.setVisibility(8);
            this.dII.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cWt.bch().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aZ(dIE, dIE);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bcn());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.dIH.setVisibility(8);
            this.dII.setVisibility(8);
            return;
        }
        this.dIH.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.dIH.getChildCount(); i2++) {
            View childAt = this.dIH.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bbh();
                tbImageView.setRadius(dimens);
                tbImageView.ni(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bcA())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bcA(), this.agt ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dqB, this.dqB);
            layoutParams.leftMargin = (this.dqB + this.dIM) * 4;
            this.dIH.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.dII.setVisibility(0);
            this.dII.setText("+" + (this.mImageList.size() - 5));
            this.dII.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.dqB - ThreadGodReplyLayout.this.dII.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.dII.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.dII.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.dII.setVisibility(8);
    }

    public void c(PostData postData) {
        this.dIL = postData.bcp();
        if (this.dIL == null) {
            this.dIG.setVisibility(8);
            return;
        }
        this.dIG.setVisibility(0);
        this.dIG.setTag(this.dIL);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.afW, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aPu().kM(R.color.cp_bg_line_g).P(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aR(this.mRootView);
            aQG();
            aQF();
            this.dHB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.dIG.ckO();
        }
    }

    private void aQG() {
        com.baidu.tieba.card.l.a(this.dIF, this.agz == null ? null : this.agz.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.dIF;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bcx());
            }
            String str = "";
            String str2 = "";
            if (this.agz != null) {
                str = this.agz.aKJ();
                str2 = this.agz.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            createConfig.setThreadData(this.agz);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (this.afS != null) {
                this.afS.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afS = onClickListener;
    }
}
