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
/* loaded from: classes21.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int eIQ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener ajN;
    private View.OnClickListener ajo;
    private TextView ajt;
    private boolean akj;
    private bw akp;
    private AgreeView eHO;
    private TextView eIR;
    private PlayVoiceBntNew eIS;
    private FrameLayout eIT;
    private TextView eIU;
    private ClickableHeaderImageView eIV;
    private PostData eIW;
    private TbRichTextVoiceInfo eIX;
    private int eIY;
    private final float eIZ;
    private View.OnClickListener eJa;
    private int epi;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.akp = null;
        this.mSkinType = 3;
        this.eIZ = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eIW != null && ThreadGodReplyLayout.this.eIW.bih() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eIW.bih().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eIW.bih().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eIW.bih().getUserId(), ThreadGodReplyLayout.this.eIW.bih().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eIW.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ajo != null) {
                        ThreadGodReplyLayout.this.ajo.onClick(view);
                    }
                }
            }
        };
        this.eJa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ajo != null) {
                    ThreadGodReplyLayout.this.ajo.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akp = null;
        this.mSkinType = 3;
        this.eIZ = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eIW != null && ThreadGodReplyLayout.this.eIW.bih() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eIW.bih().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eIW.bih().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eIW.bih().getUserId(), ThreadGodReplyLayout.this.eIW.bih().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eIW.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ajo != null) {
                        ThreadGodReplyLayout.this.ajo.onClick(view);
                    }
                }
            }
        };
        this.eJa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ajo != null) {
                    ThreadGodReplyLayout.this.ajo.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akp = null;
        this.mSkinType = 3;
        this.eIZ = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eIW != null && ThreadGodReplyLayout.this.eIW.bih() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eIW.bih().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eIW.bih().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eIW.bih().getUserId(), ThreadGodReplyLayout.this.eIW.bih().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eIW.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ajo != null) {
                        ThreadGodReplyLayout.this.ajo.onClick(view);
                    }
                }
            }
        };
        this.eJa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ajo != null) {
                    ThreadGodReplyLayout.this.ajo.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.eIV = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.eIV.setIsRound(true);
        this.eIV.setClickable(true);
        this.ajt = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.ajt.setOnClickListener(this.ajN);
        this.eHO = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.eHO.setAfterClickListener(this.eJa);
        this.eHO.setAgreeAlone(true);
        this.eIR = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.eIS = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.eIS.setVisibility(8);
        this.eIT = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.eIY = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.epi = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.eIY * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.epi, this.epi);
            layoutParams.leftMargin = (this.epi + this.eIY) * i;
            this.eIT.addView(tbImageView, layoutParams);
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
        this.eIT.setVisibility(8);
        this.eIU = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.akj = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void boE() {
        if (this.eIV != null) {
            this.eIV.setPlaceHolder(1);
        }
        int childCount = this.eIT.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eIT.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bw bwVar) {
        this.akp = bwVar;
        setData(bwVar != null ? bwVar.bjK() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.bih() == null || postData.bih().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.eIW = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.dEr()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.eIX != null && this.eIX.bCs() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!bo(this.eIR) && !bo(this.eIT) && !bo(this.eIS)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.eIR.setVisibility(8);
            return;
        }
        this.eIR.setVisibility(0);
        if (!v.a(this.eIZ, this.eIR.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.eIR.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        s.ciJ().e(new aq("c13348"));
                        ThreadGodReplyLayout.this.eIR.setMaxLines(15);
                        ThreadGodReplyLayout.this.eIR.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.eIR.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.eIR.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.eIR.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.eIR.setText(((Object) ThreadGodReplyLayout.this.eIR.getText().subSequence(0, ThreadGodReplyLayout.this.eIR.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.eIR.getPaint(), (int) this.eIZ, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.eIZ;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.eIZ - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.eIR.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.eIR.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.eIR.setText(spannableStringBuilder);
                this.eIR.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                s.ciJ().e(new aq("c13347"));
            } else {
                return;
            }
        }
        boF();
    }

    private boolean bo(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.eIV.setData(postData.bih());
            this.ajt.setText(at.cutChineseAndEnglishWithSuffix(postData.bih().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.akp != null) {
                postData.bjY().threadId = this.akp.getTid();
            }
            postData.bjY().threadId = String.valueOf(postData.getTid());
            postData.bjY().objType = 3;
            this.eHO.setData(postData.bjY());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bBq;
        if (tbRichText == null || (bBq = tbRichText.bBq()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bBq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bBx());
            } else if (next.getType() == 17) {
                String str = next.bBB().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.bfo().isShowImages()) {
            this.eIT.setVisibility(8);
            this.eIU.setVisibility(8);
            return;
        }
        TbRichText dEr = postData.dEr();
        if (dEr == null || dEr.bBq() == null) {
            this.eIT.setVisibility(8);
            this.eIU.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dEr.bBq().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bs(eIQ, eIQ);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bBw());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.eIT.setVisibility(8);
            this.eIU.setVisibility(8);
            return;
        }
        this.eIT.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.eIT.getChildCount(); i2++) {
            View childAt = this.eIT.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bAg();
                tbImageView.setRadius(dimens);
                tbImageView.rC(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bBM())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bBM(), this.akj ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.epi, this.epi);
            layoutParams.leftMargin = (this.epi + this.eIY) * 4;
            this.eIT.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.eIU.setVisibility(0);
            this.eIU.setText("+" + (this.mImageList.size() - 5));
            this.eIU.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.epi - ThreadGodReplyLayout.this.eIU.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.eIU.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.eIU.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.eIU.setVisibility(8);
    }

    public void c(PostData postData) {
        this.eIX = postData.bBy();
        if (this.eIX == null) {
            this.eIS.setVisibility(8);
            return;
        }
        this.eIS.setVisibility(0);
        this.eIS.setTag(this.eIX);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.ajt, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bnv().oP(R.color.cp_bg_line_g).X(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bf(this.mRootView);
            boF();
            boE();
            this.eHO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.eIS.changeSkin();
        }
    }

    private void boF() {
        m.a(this.eIR, this.akp == null ? null : this.akp.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.eIR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bBJ());
            }
            String str = "";
            String str2 = "";
            if (this.akp != null) {
                str = this.akp.bil();
                str2 = this.akp.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).nu(intValue).zX(str).zZ(str2).ib(true).Aa(arrayList.get(0)).ic(true).s(this.akp).ih(false);
            ImageViewerConfig dU = aVar.dU(getContext());
            dU.getIntent().putExtra("from", this.mFrom);
            dU.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
            if (this.ajo != null) {
                this.ajo.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajo = onClickListener;
    }
}
