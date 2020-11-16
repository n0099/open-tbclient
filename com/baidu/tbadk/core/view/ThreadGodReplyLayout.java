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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes20.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int eWi = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener ajR;
    private View.OnClickListener aju;
    private TextView ajz;
    private boolean akn;
    private bx akt;
    private int eBO;
    private AgreeView eVi;
    private TextView eWj;
    private PlayVoiceBntNew eWk;
    private FrameLayout eWl;
    private TextView eWm;
    private ClickableHeaderImageView eWn;
    private PostData eWo;
    private TbRichTextVoiceInfo eWp;
    private int eWq;
    private final float eWr;
    private View.OnClickListener eWs;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.akt = null;
        this.mSkinType = 3;
        this.eWr = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eWo != null && ThreadGodReplyLayout.this.eWo.blC() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eWo.blC().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eWo.blC().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eWo.blC().getUserId(), ThreadGodReplyLayout.this.eWo.blC().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eWo.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aju != null) {
                        ThreadGodReplyLayout.this.aju.onClick(view);
                    }
                }
            }
        };
        this.eWs = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aju != null) {
                    ThreadGodReplyLayout.this.aju.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akt = null;
        this.mSkinType = 3;
        this.eWr = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eWo != null && ThreadGodReplyLayout.this.eWo.blC() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eWo.blC().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eWo.blC().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eWo.blC().getUserId(), ThreadGodReplyLayout.this.eWo.blC().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eWo.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aju != null) {
                        ThreadGodReplyLayout.this.aju.onClick(view);
                    }
                }
            }
        };
        this.eWs = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aju != null) {
                    ThreadGodReplyLayout.this.aju.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akt = null;
        this.mSkinType = 3;
        this.eWr = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eWo != null && ThreadGodReplyLayout.this.eWo.blC() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eWo.blC().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eWo.blC().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eWo.blC().getUserId(), ThreadGodReplyLayout.this.eWo.blC().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eWo.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aju != null) {
                        ThreadGodReplyLayout.this.aju.onClick(view);
                    }
                }
            }
        };
        this.eWs = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aju != null) {
                    ThreadGodReplyLayout.this.aju.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.eWn = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.eWn.setIsRound(true);
        this.eWn.setClickable(true);
        this.ajz = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.ajz.setOnClickListener(this.ajR);
        this.eVi = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.eVi.setAfterClickListener(this.eWs);
        this.eVi.setAgreeAlone(true);
        this.eWj = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.eWk = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.eWk.setVisibility(8);
        this.eWl = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.eWq = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.eBO = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.eWq * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eBO, this.eBO);
            layoutParams.leftMargin = (this.eBO + this.eWq) * i;
            this.eWl.addView(tbImageView, layoutParams);
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
        this.eWl.setVisibility(8);
        this.eWm = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bsn() {
        if (this.eWn != null) {
            this.eWn.setPlaceHolder(1);
        }
        int childCount = this.eWl.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eWl.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bx bxVar) {
        this.akt = bxVar;
        setData(bxVar != null ? bxVar.bnh() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.blC() == null || postData.blC().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.eWo = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.dJS()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.eWp != null && this.eWp.bGd() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.M_H_X003));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds0));
        }
        if (!bw(this.eWj) && !bw(this.eWl) && !bw(this.eWk)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.eWj.setVisibility(8);
            return;
        }
        this.eWj.setVisibility(0);
        if (!v.a(this.eWr, this.eWj.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.eWj.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.cnT().e(new ar("c13348"));
                        ThreadGodReplyLayout.this.eWj.setMaxLines(15);
                        ThreadGodReplyLayout.this.eWj.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.eWj.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.eWj.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.eWj.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.eWj.setText(((Object) ThreadGodReplyLayout.this.eWj.getText().subSequence(0, ThreadGodReplyLayout.this.eWj.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.eWj.getPaint(), (int) this.eWr, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.eWr;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.eWr - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.eWj.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.eWj.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.eWj.setText(spannableStringBuilder);
                this.eWj.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                t.cnT().e(new ar("c13347"));
            } else {
                return;
            }
        }
        bso();
    }

    private boolean bw(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.eWn.setData(postData.blC());
            this.ajz.setText(au.cutChineseAndEnglishWithSuffix(postData.blC().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.akt != null) {
                postData.bnv().threadId = this.akt.getTid();
            }
            postData.bnv().threadId = String.valueOf(postData.getTid());
            postData.bnv().objType = 3;
            this.eVi.setData(postData.bnv());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bFb;
        if (tbRichText == null || (bFb = tbRichText.bFb()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bFb.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bFi());
            } else if (next.getType() == 17) {
                String str = next.bFm().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.biL().isShowImages()) {
            this.eWl.setVisibility(8);
            this.eWm.setVisibility(8);
            return;
        }
        TbRichText dJS = postData.dJS();
        if (dJS == null || dJS.bFb() == null) {
            this.eWl.setVisibility(8);
            this.eWm.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dJS.bFb().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bt(eWi, eWi);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bFh());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.eWl.setVisibility(8);
            this.eWm.setVisibility(8);
            return;
        }
        this.eWl.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.eWl.getChildCount(); i2++) {
            View childAt = this.eWl.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bDR();
                tbImageView.setRadius(dimens);
                tbImageView.sv(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bFx())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bFx(), this.akn ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eBO, this.eBO);
            layoutParams.leftMargin = (this.eBO + this.eWq) * 4;
            this.eWl.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.eWm.setVisibility(0);
            this.eWm.setText("+" + (this.mImageList.size() - 5));
            this.eWm.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.eBO - ThreadGodReplyLayout.this.eWm.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.eWm.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.eWm.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.eWm.setVisibility(8);
    }

    public void c(PostData postData) {
        this.eWp = postData.bFj();
        if (this.eWp == null) {
            this.eWk.setVisibility(8);
            return;
        }
        this.eWk.setVisibility(0);
        this.eWk.setTag(this.eWp);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.ajz, R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.mRootView).pb(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            bso();
            bsn();
            this.eVi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.eWk.changeSkin();
        }
    }

    private void bso() {
        n.a(this.eWj, this.akt == null ? null : this.akt.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public TextView getGodReplyContent() {
        return this.eWj;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bFu());
            }
            String str = "";
            String str2 = "";
            if (this.akt != null) {
                str = this.akt.blG();
                str2 = this.akt.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).nL(intValue).zZ(str).Ab(str2).iy(true).Ac(arrayList.get(0)).iz(true).s(this.akt).iE(false);
            ImageViewerConfig dU = aVar.dU(getContext());
            dU.getIntent().putExtra("from", this.mFrom);
            dU.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
            if (this.aju != null) {
                this.aju.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aju = onClickListener;
    }
}
