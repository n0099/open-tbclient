package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int cqz = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private TextView He;
    private View.OnClickListener Hu;
    private boolean Hx;
    private int caA;
    private View.OnClickListener clw;
    private TextView cqA;
    private PlayVoiceBntNew cqB;
    private FrameLayout cqC;
    private TextView cqD;
    private ClickableHeaderImageView cqE;
    private AgreeAloneView cqF;
    private bh cqG;
    private PostData cqH;
    private TbRichTextVoiceInfo cqI;
    private int cqJ;
    private final float cqK;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.cqG = null;
        this.mSkinType = 3;
        this.cqK = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.Hu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cqH != null && ThreadGodReplyLayout.this.cqH.aiE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cqH.aiE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cqH.aiE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cqH.aiE().getUserId(), ThreadGodReplyLayout.this.cqH.aiE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cqH.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.clw != null) {
                        ThreadGodReplyLayout.this.clw.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cqG = null;
        this.mSkinType = 3;
        this.cqK = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.Hu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cqH != null && ThreadGodReplyLayout.this.cqH.aiE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cqH.aiE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cqH.aiE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cqH.aiE().getUserId(), ThreadGodReplyLayout.this.cqH.aiE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cqH.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.clw != null) {
                        ThreadGodReplyLayout.this.clw.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cqG = null;
        this.mSkinType = 3;
        this.cqK = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.Hu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cqH != null && ThreadGodReplyLayout.this.cqH.aiE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cqH.aiE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cqH.aiE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cqH.aiE().getUserId(), ThreadGodReplyLayout.this.cqH.aiE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cqH.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.clw != null) {
                        ThreadGodReplyLayout.this.clw.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.cqE = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.cqE.setIsRound(true);
        this.cqE.setClickable(true);
        this.He = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.He.setOnClickListener(this.Hu);
        this.cqF = (AgreeAloneView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.cqA = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.cqB = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.cqB.setVisibility(8);
        this.cqC = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.cqJ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.caA = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.cqJ * 4)) / 5;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.caA, this.caA);
            layoutParams.leftMargin = (this.caA + this.cqJ) * i;
            this.cqC.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            int aH = com.baidu.tbadk.util.e.aH(arrayList);
            tbImageView.setDefaultBgResource(aH);
            arrayList.add(Integer.valueOf(aH));
        }
        this.cqC.setVisibility(8);
        this.cqD = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aob() {
        if (this.cqE != null) {
            this.cqE.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
        }
        int childCount = this.cqC.getChildCount();
        if (childCount > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cqC.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    int aH = com.baidu.tbadk.util.e.aH(arrayList);
                    ((TbImageView) childAt).setDefaultBgResource(aH);
                    arrayList.add(Integer.valueOf(aH));
                }
            }
        }
    }

    public void setData(bh bhVar) {
        this.cqG = bhVar;
        setData(bhVar.akb());
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aiE() == null || postData.aiE().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.cqH = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cop()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.cqI != null && this.cqI.aAd() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!aX(this.cqA) && !aX(this.cqC) && !aX(this.cqB)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.cqA.setVisibility(8);
            return;
        }
        if (!v.a(this.cqK, this.cqA.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.cqA.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.god_reply_expand_flag));
            Drawable drawable = am.getDrawable(R.drawable.icon_common_arrow_blue);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.bau().c(new an("c13348"));
                        ThreadGodReplyLayout.this.cqA.setMaxLines(15);
                        ThreadGodReplyLayout.this.cqA.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.cqA.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.cqA.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.cqA.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.cqA.setText(((Object) ThreadGodReplyLayout.this.cqA.getText().subSequence(0, ThreadGodReplyLayout.this.cqA.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.cqA.getPaint(), (int) this.cqK, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.cqK;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.cqK - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.cqA.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.cqA.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
                this.cqA.setText(spannableStringBuilder);
                this.cqA.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
                t.bau().c(new an("c13347"));
            } else {
                return;
            }
        }
        if (this.cqG != null) {
            com.baidu.tieba.card.n.a(this.cqA, this.cqG.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean aX(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.cqE.setData(postData.aiE());
            this.He.setText(aq.cutChineseAndEnglishWithSuffix(postData.aiE().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.cqG != null) {
                postData.akt().threadId = this.cqG.getTid();
            }
            postData.akt().threadId = String.valueOf(postData.getTid());
            postData.akt().objType = 3;
            this.cqF.setData(postData.akt());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> azf;
        if (tbRichText == null || (azf = tbRichText.azf()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = azf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.azo());
            } else if (next.getType() == 17) {
                String str = next.azs().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    spannableStringBuilder.append((CharSequence) "[表情]");
                }
            } else if (next.getType() == 20) {
                spannableStringBuilder.append((CharSequence) "[表情]");
            }
        }
        if (spannableStringBuilder.length() > 0) {
            for (com.baidu.tbadk.widget.richText.c cVar : (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, com.baidu.tbadk.widget.richText.c.class)) {
                spannableStringBuilder.removeSpan(cVar);
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
        if (!com.baidu.tbadk.core.i.ago().isShowImages()) {
            this.cqC.setVisibility(8);
            this.cqD.setVisibility(8);
            return;
        }
        TbRichText cop = postData.cop();
        if (cop == null || cop.azf() == null) {
            this.cqC.setVisibility(8);
            this.cqD.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cop.azf().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aw(cqz, cqz);
                if (next.getType() == 8) {
                    this.mImageList.add(next.azn());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.cqC.setVisibility(8);
            this.cqD.setVisibility(8);
            return;
        }
        this.cqC.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        int i = 0;
        for (int i2 = 0; i2 < this.cqC.getChildCount(); i2++) {
            View childAt = this.cqC.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.ayh();
                tbImageView.setRadius(dimens);
                if (i2 == 0) {
                    tbImageView.ko(5);
                }
                if (i2 == this.mImageList.size() - 1 || i2 == 4) {
                    tbImageView.ko(10);
                }
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.azB())) {
                        tbImageView.startLoad(tbRichTextImageInfo.azB(), this.Hx ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.caA, this.caA);
            layoutParams.leftMargin = (this.caA + this.cqJ) * 4;
            this.cqC.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.cqD.setVisibility(0);
            this.cqD.setText("+" + this.mImageList.size());
            this.cqD.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.caA - ThreadGodReplyLayout.this.cqD.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.cqD.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.cqD.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.cqD.setVisibility(8);
    }

    public void c(PostData postData) {
        this.cqI = postData.azp();
        if (this.cqI == null) {
            this.cqB.setVisibility(8);
            return;
        }
        this.cqB.setVisibility(0);
        this.cqB.setTag(this.cqI);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_g);
            am.setViewTextColor(this.He, (int) R.color.cp_cont_b);
            this.cqF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aob();
            this.cqB.bno();
        }
    }

    public TextView getGodReplyContent() {
        return this.cqA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.azy());
            }
            String str = "";
            String str2 = "";
            if (this.cqG != null) {
                str = this.cqG.aiJ();
                str2 = this.cqG.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (this.clw != null) {
                this.clw.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.clw = onClickListener;
    }
}
