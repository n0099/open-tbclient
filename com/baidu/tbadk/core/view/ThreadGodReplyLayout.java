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
    private static final int fno = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener akV;
    private boolean alQ;
    private bz alW;
    private TextView ala;
    private View.OnClickListener alu;
    private int eSI;
    private AgreeView fmo;
    private TextView fnp;
    private PlayVoiceBntNew fnq;
    private FrameLayout fnr;
    private TextView fns;
    private ClickableHeaderImageView fnt;
    private PostData fnu;
    private TbRichTextVoiceInfo fnv;
    private int fnw;
    private final float fnx;
    private View.OnClickListener fny;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.alW = null;
        this.mSkinType = 3;
        this.fnx = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.alu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fnu != null && ThreadGodReplyLayout.this.fnu.brr() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fnu.brr().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fnu.brr().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fnu.brr().getUserId(), ThreadGodReplyLayout.this.fnu.brr().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fnu.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.akV != null) {
                        ThreadGodReplyLayout.this.akV.onClick(view);
                    }
                }
            }
        };
        this.fny = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.akV != null) {
                    ThreadGodReplyLayout.this.akV.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alW = null;
        this.mSkinType = 3;
        this.fnx = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.alu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fnu != null && ThreadGodReplyLayout.this.fnu.brr() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fnu.brr().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fnu.brr().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fnu.brr().getUserId(), ThreadGodReplyLayout.this.fnu.brr().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fnu.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.akV != null) {
                        ThreadGodReplyLayout.this.akV.onClick(view);
                    }
                }
            }
        };
        this.fny = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.akV != null) {
                    ThreadGodReplyLayout.this.akV.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alW = null;
        this.mSkinType = 3;
        this.fnx = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.alu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.fnu != null && ThreadGodReplyLayout.this.fnu.brr() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.fnu.brr().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.fnu.brr().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.fnu.brr().getUserId(), ThreadGodReplyLayout.this.fnu.brr().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.fnu.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.akV != null) {
                        ThreadGodReplyLayout.this.akV.onClick(view);
                    }
                }
            }
        };
        this.fny = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.akV != null) {
                    ThreadGodReplyLayout.this.akV.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.fnt = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.fnt.setIsRound(true);
        this.fnt.setClickable(true);
        this.ala = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.ala.setOnClickListener(this.alu);
        this.fmo = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.fmo.setAfterClickListener(this.fny);
        this.fmo.setAgreeAlone(true);
        this.fnp = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.fnq = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.fnq.setVisibility(8);
        this.fnr = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.fnw = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.eSI = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.fnw * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eSI, this.eSI);
            layoutParams.leftMargin = (this.eSI + this.fnw) * i;
            this.fnr.addView(tbImageView, layoutParams);
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
        this.fnr.setVisibility(8);
        this.fns = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void byj() {
        if (this.fnt != null) {
            this.fnt.setPlaceHolder(1);
        }
        int childCount = this.fnr.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fnr.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bz bzVar) {
        this.alW = bzVar;
        setData(bzVar != null ? bzVar.bsX() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.brr() == null || postData.brr().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.fnu = postData;
        setVisibility(0);
        a(postData);
        c(a(postData.dPg()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.fnv != null && this.fnv.bLW() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.M_H_X003));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds0));
        }
        if (!bI(this.fnp) && !bI(this.fnr) && !bI(this.fnq)) {
            setVisibility(8);
        }
    }

    private void c(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.fnp.setVisibility(8);
            return;
        }
        this.fnp.setVisibility(0);
        if (!v.a(this.fnx, this.fnp.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.fnp.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        s.cvb().e(new aq("c13348"));
                        ThreadGodReplyLayout.this.fnp.setMaxLines(15);
                        ThreadGodReplyLayout.this.fnp.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.fnp.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.fnp.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.fnp.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.fnp.setText(((Object) ThreadGodReplyLayout.this.fnp.getText().subSequence(0, ThreadGodReplyLayout.this.fnp.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.fnp.getPaint(), (int) this.fnx, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.fnx;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.fnx - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.fnp.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.fnp.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.fnp.setText(spannableStringBuilder);
                this.fnp.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                s.cvb().e(new aq("c13347"));
            } else {
                return;
            }
        }
        byk();
    }

    private boolean bI(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.fnt.setData(postData.brr());
            this.ala.setText(at.cutChineseAndEnglishWithSuffix(postData.brr().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.alW != null) {
                postData.btl().threadId = this.alW.getTid();
            }
            postData.btl().threadId = String.valueOf(postData.getTid());
            postData.btl().objType = 3;
            this.fmo.setData(postData.btl());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bKX;
        if (tbRichText == null || (bKX = tbRichText.bKX()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bKX.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bLe());
            } else if (next.getType() == 17) {
                String str = next.bLi().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.bov().isShowImages()) {
            this.fnr.setVisibility(8);
            this.fns.setVisibility(8);
            return;
        }
        TbRichText dPg = postData.dPg();
        if (dPg == null || dPg.bKX() == null) {
            this.fnr.setVisibility(8);
            this.fns.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dPg.bKX().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bt(fno, fno);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bLd());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.fnr.setVisibility(8);
            this.fns.setVisibility(8);
            return;
        }
        this.fnr.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.fnr.getChildCount(); i2++) {
            View childAt = this.fnr.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bJM();
                tbImageView.setRadius(dimens);
                tbImageView.tj(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bLq())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bLq(), this.alQ ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eSI, this.eSI);
            layoutParams.leftMargin = (this.eSI + this.fnw) * 4;
            this.fnr.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.fns.setVisibility(0);
            this.fns.setText("+" + (this.mImageList.size() - 5));
            this.fns.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.eSI - ThreadGodReplyLayout.this.fns.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.fns.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.fns.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.fns.setVisibility(8);
    }

    public void c(PostData postData) {
        this.fnv = postData.bLf();
        if (this.fnv == null) {
            this.fnq.setVisibility(8);
            return;
        }
        this.fnq.setVisibility(0);
        this.fnq.setTag(this.fnv);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setViewTextColor(this.ala, R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.mRootView).pK(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            byk();
            byj();
            this.fmo.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fnq.bxO();
        }
    }

    private void byk() {
        m.a(this.fnp, this.alW == null ? null : this.alW.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public TextView getGodReplyContent() {
        return this.fnp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bLn());
            }
            String str = "";
            String str2 = "";
            if (this.alW != null) {
                str = this.alW.brv();
                str2 = this.alW.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).ot(intValue).AD(str).AF(str2).ji(true).AG(arrayList.get(0)).jj(true).s(this.alW).jo(false);
            ImageViewerConfig eS = aVar.eS(getContext());
            eS.getIntent().putExtra("from", this.mFrom);
            eS.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS));
            if (this.akV != null) {
                this.akV.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akV = onClickListener;
    }
}
