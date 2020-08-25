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
/* loaded from: classes15.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int euy = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener aiA;
    private TextView aiF;
    private View.OnClickListener aiZ;
    private boolean ajr;
    private bw ajx;
    private int eaP;
    private AgreeView etw;
    private PlayVoiceBntNew euA;
    private FrameLayout euB;
    private TextView euC;
    private ClickableHeaderImageView euD;
    private PostData euE;
    private TbRichTextVoiceInfo euF;
    private int euG;
    private final float euH;
    private View.OnClickListener euI;
    private TextView euz;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.ajx = null;
        this.mSkinType = 3;
        this.euH = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.aiZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.euE != null && ThreadGodReplyLayout.this.euE.beE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.euE.beE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.euE.beE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.euE.beE().getUserId(), ThreadGodReplyLayout.this.euE.beE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.euE.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aiA != null) {
                        ThreadGodReplyLayout.this.aiA.onClick(view);
                    }
                }
            }
        };
        this.euI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aiA != null) {
                    ThreadGodReplyLayout.this.aiA.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajx = null;
        this.mSkinType = 3;
        this.euH = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.aiZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.euE != null && ThreadGodReplyLayout.this.euE.beE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.euE.beE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.euE.beE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.euE.beE().getUserId(), ThreadGodReplyLayout.this.euE.beE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.euE.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aiA != null) {
                        ThreadGodReplyLayout.this.aiA.onClick(view);
                    }
                }
            }
        };
        this.euI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aiA != null) {
                    ThreadGodReplyLayout.this.aiA.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajx = null;
        this.mSkinType = 3;
        this.euH = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.aiZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.euE != null && ThreadGodReplyLayout.this.euE.beE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.euE.beE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.euE.beE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.euE.beE().getUserId(), ThreadGodReplyLayout.this.euE.beE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.euE.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aiA != null) {
                        ThreadGodReplyLayout.this.aiA.onClick(view);
                    }
                }
            }
        };
        this.euI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aiA != null) {
                    ThreadGodReplyLayout.this.aiA.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.euD = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.euD.setIsRound(true);
        this.euD.setClickable(true);
        this.aiF = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.aiF.setOnClickListener(this.aiZ);
        this.etw = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.etw.setAfterClickListener(this.euI);
        this.etw.setAgreeAlone(true);
        this.euz = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.euA = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.euA.setVisibility(8);
        this.euB = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.euG = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.eaP = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.euG * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eaP, this.eaP);
            layoutParams.leftMargin = (this.eaP + this.euG) * i;
            this.euB.addView(tbImageView, layoutParams);
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
        this.euB.setVisibility(8);
        this.euC = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bkZ() {
        if (this.euD != null) {
            this.euD.setPlaceHolder(1);
        }
        int childCount = this.euB.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.euB.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bw bwVar) {
        this.ajx = bwVar;
        setData(bwVar != null ? bwVar.bgh() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.beE() == null || postData.beE().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.euE = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.dwH()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.euF != null && this.euF.byy() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!bi(this.euz) && !bi(this.euB) && !bi(this.euA)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.euz.setVisibility(8);
            return;
        }
        this.euz.setVisibility(0);
        if (!v.a(this.euH, this.euz.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.euz.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        s.cbX().e(new aq("c13348"));
                        ThreadGodReplyLayout.this.euz.setMaxLines(15);
                        ThreadGodReplyLayout.this.euz.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.euz.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.euz.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.euz.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.euz.setText(((Object) ThreadGodReplyLayout.this.euz.getText().subSequence(0, ThreadGodReplyLayout.this.euz.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.euz.getPaint(), (int) this.euH, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.euH;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.euH - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.euz.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.euz.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.euz.setText(spannableStringBuilder);
                this.euz.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                s.cbX().e(new aq("c13347"));
            } else {
                return;
            }
        }
        bla();
    }

    private boolean bi(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.euD.setData(postData.beE());
            this.aiF.setText(at.cutChineseAndEnglishWithSuffix(postData.beE().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.ajx != null) {
                postData.bgv().threadId = this.ajx.getTid();
            }
            postData.bgv().threadId = String.valueOf(postData.getTid());
            postData.bgv().objType = 3;
            this.etw.setData(postData.bgv());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bxw;
        if (tbRichText == null || (bxw = tbRichText.bxw()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bxw.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bxD());
            } else if (next.getType() == 17) {
                String str = next.bxH().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.bbM().isShowImages()) {
            this.euB.setVisibility(8);
            this.euC.setVisibility(8);
            return;
        }
        TbRichText dwH = postData.dwH();
        if (dwH == null || dwH.bxw() == null) {
            this.euB.setVisibility(8);
            this.euC.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dwH.bxw().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bt(euy, euy);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bxC());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.euB.setVisibility(8);
            this.euC.setVisibility(8);
            return;
        }
        this.euB.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.euB.getChildCount(); i2++) {
            View childAt = this.euB.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bwm();
                tbImageView.setRadius(dimens);
                tbImageView.qN(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bxS())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bxS(), this.ajr ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eaP, this.eaP);
            layoutParams.leftMargin = (this.eaP + this.euG) * 4;
            this.euB.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.euC.setVisibility(0);
            this.euC.setText("+" + (this.mImageList.size() - 5));
            this.euC.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.eaP - ThreadGodReplyLayout.this.euC.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.euC.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.euC.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.euC.setVisibility(8);
    }

    public void c(PostData postData) {
        this.euF = postData.bxE();
        if (this.euF == null) {
            this.euA.setVisibility(8);
            return;
        }
        this.euA.setVisibility(0);
        this.euA.setTag(this.euF);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.aiF, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bjQ().of(R.color.cp_bg_line_g).V(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aZ(this.mRootView);
            bla();
            bkZ();
            this.etw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.euA.changeSkin();
        }
    }

    private void bla() {
        m.a(this.euz, this.ajx == null ? null : this.ajx.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.euz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bxP());
            }
            String str = "";
            String str2 = "";
            if (this.ajx != null) {
                str = this.ajx.beI();
                str2 = this.ajx.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).mM(intValue).yP(str).yR(str2).hH(true).yS(arrayList.get(0)).hI(true).r(this.ajx).hN(false);
            ImageViewerConfig dP = aVar.dP(getContext());
            dP.getIntent().putExtra("from", this.mFrom);
            dP.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
            if (this.aiA != null) {
                this.aiA.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiA = onClickListener;
    }
}
