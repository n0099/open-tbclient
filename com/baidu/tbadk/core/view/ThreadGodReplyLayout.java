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
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int eRm = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener ajO;
    private View.OnClickListener ajp;
    private TextView aju;
    private boolean akk;
    private bw akq;
    private AgreeView eQk;
    private TextView eRn;
    private PlayVoiceBntNew eRo;
    private FrameLayout eRp;
    private TextView eRq;
    private ClickableHeaderImageView eRr;
    private PostData eRs;
    private TbRichTextVoiceInfo eRt;
    private int eRu;
    private final float eRv;
    private View.OnClickListener eRw;
    private int exG;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.akq = null;
        this.mSkinType = 3;
        this.eRv = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eRs != null && ThreadGodReplyLayout.this.eRs.bka() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eRs.bka().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eRs.bka().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eRs.bka().getUserId(), ThreadGodReplyLayout.this.eRs.bka().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eRs.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ajp != null) {
                        ThreadGodReplyLayout.this.ajp.onClick(view);
                    }
                }
            }
        };
        this.eRw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ajp != null) {
                    ThreadGodReplyLayout.this.ajp.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akq = null;
        this.mSkinType = 3;
        this.eRv = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eRs != null && ThreadGodReplyLayout.this.eRs.bka() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eRs.bka().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eRs.bka().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eRs.bka().getUserId(), ThreadGodReplyLayout.this.eRs.bka().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eRs.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ajp != null) {
                        ThreadGodReplyLayout.this.ajp.onClick(view);
                    }
                }
            }
        };
        this.eRw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ajp != null) {
                    ThreadGodReplyLayout.this.ajp.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akq = null;
        this.mSkinType = 3;
        this.eRv = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.eRs != null && ThreadGodReplyLayout.this.eRs.bka() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.eRs.bka().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.eRs.bka().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.eRs.bka().getUserId(), ThreadGodReplyLayout.this.eRs.bka().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.eRs.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ajp != null) {
                        ThreadGodReplyLayout.this.ajp.onClick(view);
                    }
                }
            }
        };
        this.eRw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ajp != null) {
                    ThreadGodReplyLayout.this.ajp.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.eRr = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.eRr.setIsRound(true);
        this.eRr.setClickable(true);
        this.aju = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.aju.setOnClickListener(this.ajO);
        this.eQk = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.eQk.setAfterClickListener(this.eRw);
        this.eQk.setAgreeAlone(true);
        this.eRn = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.eRo = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.eRo.setVisibility(8);
        this.eRp = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.eRu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.exG = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.eRu * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.exG, this.exG);
            layoutParams.leftMargin = (this.exG + this.eRu) * i;
            this.eRp.addView(tbImageView, layoutParams);
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
        this.eRp.setVisibility(8);
        this.eRq = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bqx() {
        if (this.eRr != null) {
            this.eRr.setPlaceHolder(1);
        }
        int childCount = this.eRp.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eRp.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bw bwVar) {
        this.akq = bwVar;
        setData(bwVar != null ? bwVar.blD() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.bka() == null || postData.bka().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.eRs = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.dHz()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.eRt != null && this.eRt.bEl() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!bp(this.eRn) && !bp(this.eRp) && !bp(this.eRo)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.eRn.setVisibility(8);
            return;
        }
        this.eRn.setVisibility(0);
        if (!v.a(this.eRv, this.eRn.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.eRn.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.clQ().e(new aq("c13348"));
                        ThreadGodReplyLayout.this.eRn.setMaxLines(15);
                        ThreadGodReplyLayout.this.eRn.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.eRn.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.eRn.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.eRn.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.eRn.setText(((Object) ThreadGodReplyLayout.this.eRn.getText().subSequence(0, ThreadGodReplyLayout.this.eRn.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.eRn.getPaint(), (int) this.eRv, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.eRv;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.eRv - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.eRn.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.eRn.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.eRn.setText(spannableStringBuilder);
                this.eRn.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                t.clQ().e(new aq("c13347"));
            } else {
                return;
            }
        }
        bqy();
    }

    private boolean bp(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.eRr.setData(postData.bka());
            this.aju.setText(at.cutChineseAndEnglishWithSuffix(postData.bka().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.akq != null) {
                postData.blR().threadId = this.akq.getTid();
            }
            postData.blR().threadId = String.valueOf(postData.getTid());
            postData.blR().objType = 3;
            this.eQk.setData(postData.blR());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bDj;
        if (tbRichText == null || (bDj = tbRichText.bDj()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bDj.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bDq());
            } else if (next.getType() == 17) {
                String str = next.bDu().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.k.bhh().isShowImages()) {
            this.eRp.setVisibility(8);
            this.eRq.setVisibility(8);
            return;
        }
        TbRichText dHz = postData.dHz();
        if (dHz == null || dHz.bDj() == null) {
            this.eRp.setVisibility(8);
            this.eRq.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dHz.bDj().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bt(eRm, eRm);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bDp());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.eRp.setVisibility(8);
            this.eRq.setVisibility(8);
            return;
        }
        this.eRp.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.eRp.getChildCount(); i2++) {
            View childAt = this.eRp.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bBZ();
                tbImageView.setRadius(dimens);
                tbImageView.rN(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bDF())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bDF(), this.akk ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.exG, this.exG);
            layoutParams.leftMargin = (this.exG + this.eRu) * 4;
            this.eRp.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.eRq.setVisibility(0);
            this.eRq.setText("+" + (this.mImageList.size() - 5));
            this.eRq.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.exG - ThreadGodReplyLayout.this.eRq.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.eRq.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.eRq.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.eRq.setVisibility(8);
    }

    public void c(PostData postData) {
        this.eRt = postData.bDr();
        if (this.eRt == null) {
            this.eRo.setVisibility(8);
            return;
        }
        this.eRo.setVisibility(0);
        this.eRo.setTag(this.eRt);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.aju, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bpo().pa(R.color.cp_bg_line_g).Z(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bg(this.mRootView);
            bqy();
            bqx();
            this.eQk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.eRo.changeSkin();
        }
    }

    private void bqy() {
        n.a(this.eRn, this.akq == null ? null : this.akq.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.eRn;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bDC());
            }
            String str = "";
            String str2 = "";
            if (this.akq != null) {
                str = this.akq.bke();
                str2 = this.akq.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).nF(intValue).Aq(str).As(str2).io(true).At(arrayList.get(0)).ip(true).s(this.akq).iu(false);
            ImageViewerConfig dU = aVar.dU(getContext());
            dU.getIntent().putExtra("from", this.mFrom);
            dU.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
            if (this.ajp != null) {
                this.ajp.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajp = onClickListener;
    }
}
