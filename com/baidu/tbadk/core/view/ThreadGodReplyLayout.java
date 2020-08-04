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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes15.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int ekD = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener ahL;
    private View.OnClickListener ahn;
    private TextView ahr;
    private boolean aib;
    private bv aii;
    private int dRu;
    private AgreeView ejB;
    private TextView ekE;
    private PlayVoiceBntNew ekF;
    private FrameLayout ekG;
    private TextView ekH;
    private ClickableHeaderImageView ekI;
    private PostData ekJ;
    private TbRichTextVoiceInfo ekK;
    private int ekL;
    private final float ekM;
    private View.OnClickListener ekN;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.aii = null;
        this.mSkinType = 3;
        this.ekM = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ahL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ekJ != null && ThreadGodReplyLayout.this.ekJ.aWl() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.ekJ.aWl().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.ekJ.aWl().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.ekJ.aWl().getUserId(), ThreadGodReplyLayout.this.ekJ.aWl().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.ekJ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ahn != null) {
                        ThreadGodReplyLayout.this.ahn.onClick(view);
                    }
                }
            }
        };
        this.ekN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ahn != null) {
                    ThreadGodReplyLayout.this.ahn.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aii = null;
        this.mSkinType = 3;
        this.ekM = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ahL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ekJ != null && ThreadGodReplyLayout.this.ekJ.aWl() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.ekJ.aWl().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.ekJ.aWl().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.ekJ.aWl().getUserId(), ThreadGodReplyLayout.this.ekJ.aWl().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.ekJ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ahn != null) {
                        ThreadGodReplyLayout.this.ahn.onClick(view);
                    }
                }
            }
        };
        this.ekN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ahn != null) {
                    ThreadGodReplyLayout.this.ahn.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aii = null;
        this.mSkinType = 3;
        this.ekM = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ahL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ekJ != null && ThreadGodReplyLayout.this.ekJ.aWl() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.ekJ.aWl().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.ekJ.aWl().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.ekJ.aWl().getUserId(), ThreadGodReplyLayout.this.ekJ.aWl().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.ekJ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ahn != null) {
                        ThreadGodReplyLayout.this.ahn.onClick(view);
                    }
                }
            }
        };
        this.ekN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ahn != null) {
                    ThreadGodReplyLayout.this.ahn.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.ekI = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.ekI.setIsRound(true);
        this.ekI.setClickable(true);
        this.ahr = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.ahr.setOnClickListener(this.ahL);
        this.ejB = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.ejB.setAfterClickListener(this.ekN);
        this.ejB.setAgreeAlone(true);
        this.ekE = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.ekF = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.ekF.setVisibility(8);
        this.ekG = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.ekL = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.dRu = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.ekL * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dRu, this.dRu);
            layoutParams.leftMargin = (this.dRu + this.ekL) * i;
            this.ekG.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ao.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            tbImageView.setPlaceHolder(2);
        }
        this.ekG.setVisibility(8);
        this.ekH = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bcB() {
        if (this.ekI != null) {
            this.ekI.setPlaceHolder(1);
        }
        int childCount = this.ekG.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ekG.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bv bvVar) {
        this.aii = bvVar;
        setData(bvVar != null ? bvVar.aXO() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aWl() == null || postData.aWl().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.ekJ = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.dlk()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.ekK != null && this.ekK.bpK() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!bg(this.ekE) && !bg(this.ekG) && !bg(this.ekF)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.ekE.setVisibility(8);
            return;
        }
        this.ekE.setVisibility(0);
        if (!v.a(this.ekM, this.ekE.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.ekE.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        s.bRL().e(new ap("c13348"));
                        ThreadGodReplyLayout.this.ekE.setMaxLines(15);
                        ThreadGodReplyLayout.this.ekE.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.ekE.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.ekE.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.ekE.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.ekE.setText(((Object) ThreadGodReplyLayout.this.ekE.getText().subSequence(0, ThreadGodReplyLayout.this.ekE.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.ekE.getPaint(), (int) this.ekM, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.ekM;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.ekM - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.ekE.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.ekE.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.ekE.setText(spannableStringBuilder);
                this.ekE.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                s.bRL().e(new ap("c13347"));
            } else {
                return;
            }
        }
        bcC();
    }

    private boolean bg(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.ekI.setData(postData.aWl());
            this.ahr.setText(as.cutChineseAndEnglishWithSuffix(postData.aWl().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.aii != null) {
                postData.aYc().threadId = this.aii.getTid();
            }
            postData.aYc().threadId = String.valueOf(postData.getTid());
            postData.aYc().objType = 3;
            this.ejB.setData(postData.aYc());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> boJ;
        if (tbRichText == null || (boJ = tbRichText.boJ()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = boJ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.boQ());
            } else if (next.getType() == 17) {
                String str = next.boU().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.aTv().isShowImages()) {
            this.ekG.setVisibility(8);
            this.ekH.setVisibility(8);
            return;
        }
        TbRichText dlk = postData.dlk();
        if (dlk == null || dlk.boJ() == null) {
            this.ekG.setVisibility(8);
            this.ekH.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dlk.boJ().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bk(ekD, ekD);
                if (next.getType() == 8) {
                    this.mImageList.add(next.boP());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.ekG.setVisibility(8);
            this.ekH.setVisibility(8);
            return;
        }
        this.ekG.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.ekG.getChildCount(); i2++) {
            View childAt = this.ekG.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bny();
                tbImageView.setRadius(dimens);
                tbImageView.oB(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bpe())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bpe(), this.aib ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dRu, this.dRu);
            layoutParams.leftMargin = (this.dRu + this.ekL) * 4;
            this.ekG.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.ekH.setVisibility(0);
            this.ekH.setText("+" + (this.mImageList.size() - 5));
            this.ekH.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.dRu - ThreadGodReplyLayout.this.ekH.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.ekH.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.ekH.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.ekH.setVisibility(8);
    }

    public void c(PostData postData) {
        this.ekK = postData.boR();
        if (this.ekK == null) {
            this.ekF.setVisibility(8);
            return;
        }
        this.ekF.setVisibility(0);
        this.ekF.setTag(this.ekK);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setViewTextColor(this.ahr, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bbr().mb(R.color.cp_bg_line_g).Q(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aX(this.mRootView);
            bcC();
            bcB();
            this.ejB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.ekF.changeSkin();
        }
    }

    private void bcC() {
        m.a(this.ekE, this.aii == null ? null : this.aii.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.ekE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bpb());
            }
            String str = "";
            String str2 = "";
            if (this.aii != null) {
                str = this.aii.aWp();
                str2 = this.aii.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).kG(intValue).wE(str).wG(str2).hl(true).wH(arrayList.get(0)).hm(true).r(this.aii).hr(false);
            ImageViewerConfig dI = aVar.dI(getContext());
            dI.getIntent().putExtra("from", this.mFrom);
            dI.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI));
            if (this.ahn != null) {
                this.ahn.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahn = onClickListener;
    }
}
