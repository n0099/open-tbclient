package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.card.al;
import com.baidu.card.p;
import com.baidu.tbadk.a.b.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgTextPicLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private boolean ahF;
    private com.baidu.tbadk.core.data.a ahi;
    public TextView aia;
    private aa<com.baidu.tbadk.core.data.a> ajj;
    private boolean alQ;
    private TbImageView.c alY;
    public PlayVoiceBntNew amd;
    private boolean amf;
    private boolean amg;
    private LinkedList<MediaData> amh;
    public RelativeLayout amk;
    public TbImageView aml;
    public TbImageView amm;
    public TbImageView amn;
    private TextView amo;
    public TbImageView amp;
    private int amq;
    private d amr;
    protected boolean ams;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int ama = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int amb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int amc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int ahY = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgTextPicLayout(Context context) {
        this(context, null);
    }

    public MultiImgTextPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alQ = true;
        this.ahi = null;
        this.amf = false;
        this.amg = false;
        this.amq = 0;
        this.ams = false;
        this.mLastScreenWidth = 0;
        this.ahF = false;
        this.alY = new TbImageView.c() { // from class: com.baidu.card.view.MultiImgTextPicLayout.3
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                float f7;
                float f8;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ee = c.bGq().Ee(com.baidu.adp.lib.e.d.mx().genCacheKey(tbImageView.getUrl(), MultiImgTextPicLayout.this.alQ ? 13 : 14));
                    if (Ee != null) {
                        int width = Ee.getWidth();
                        i = Ee.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                            float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                            if (i2 * height > width2 * i) {
                                f5 = height / i;
                                float f9 = i2 * smartCropCenterPointWidthRatio * f5;
                                if (f9 < width2 * 0.5f) {
                                    f8 = 0.0f;
                                } else if ((i2 * f5) - f9 < width2 * 0.5f) {
                                    f8 = width2 - (i2 * f5);
                                } else {
                                    f8 = (width2 * 0.5f) - f9;
                                }
                                f6 = 0.0f;
                                f7 = f8;
                            } else {
                                f5 = width2 / i2;
                                float f10 = i * smartCropCenterPointHeightRatio * f5;
                                if (f10 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = 0.0f;
                                } else if ((i * f5) - f10 < height * 0.5f) {
                                    f6 = height - (i * f5);
                                    f7 = 0.0f;
                                } else {
                                    f6 = (height * 0.5f) - f10;
                                    f7 = 0.0f;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f7, f6);
                        } else if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f = height / i;
                                f3 = (width2 - (i2 * f)) * 0.5f;
                                f2 = 0.0f;
                            } else {
                                f = width2 / i2;
                                f2 = (height - (i * f)) * 0.5f;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f, f);
                            if (MultiImgTextPicLayout.this.ams && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f2);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_card_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aia = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.amd = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.amd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgTextPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MultiImgTextPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgTextPicLayout.this.ahi);
                }
            }
        });
        int equipmentWidth = ((l.getEquipmentWidth(getContext()) - (al.ajs * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
        this.amk = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        b.j(this.amk, R.dimen.tbds26, R.dimen.tbds14);
        b.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        b.a(this.aia, R.dimen.tbds7, R.dimen.tbds10);
        this.amk.getLayoutParams().height = equipmentWidth;
        this.aml = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.aml.setDrawCorner(true);
        this.aml.setRadiusById(R.string.J_X12);
        this.aml.setPlaceHolder(2);
        this.aml.setConrers(15);
        this.aml.getLayoutParams().height = equipmentWidth;
        this.aml.getLayoutParams().width = equipmentWidth;
        this.amm = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.amm.setDrawCorner(false);
        this.amm.setPlaceHolder(2);
        this.amm.setRadiusById(R.string.J_X02);
        this.amm.setConrers(15);
        this.amm.getLayoutParams().height = equipmentWidth;
        this.amm.getLayoutParams().width = equipmentWidth;
        this.amn = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.amn.setDrawCorner(true);
        this.amn.setPlaceHolder(2);
        this.amn.setRadiusById(R.string.J_X11);
        this.amn.setConrers(15);
        this.amn.getLayoutParams().height = equipmentWidth;
        this.amn.getLayoutParams().width = equipmentWidth;
        this.amo = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.amo.getLayoutParams().height = equipmentWidth;
        this.amo.getLayoutParams().width = equipmentWidth;
        float[] ps = com.baidu.tbadk.core.elementsMaven.a.ps(R.array.S_O_X001);
        this.amo.setShadowLayer(ps[1], ps[2], ps[3], (int) ps[0]);
        this.amo.setTypeface(com.baidu.tbadk.core.elementsMaven.a.Bt(com.baidu.tbadk.core.elementsMaven.a.getString(R.string.F_X02)));
        this.amp = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.amp.setRadiusById(R.string.J_X05);
        this.amp.setConrers(15);
        this.amp.setDrawCorner(true);
        this.amp.setPlaceHolder(3);
        this.amp.setLongIconSupport(true);
        this.amp.setGifIconSupport(true);
        b.j(this.amp, R.dimen.tbds28, R.dimen.tbds14);
        this.amr = new d() { // from class: com.baidu.card.view.MultiImgTextPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void c(View view, int i, boolean z) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MultiImgTextPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MultiImgTextPicLayout.this.ahi.objType = 2;
                    subClickListener.akp = Boolean.valueOf(z);
                    subClickListener.a(view, MultiImgTextPicLayout.this.ahi);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fsM) {
                    ay.a(view, MultiImgTextPicLayout.this.alQ, MultiImgTextPicLayout.this.amh, i, MultiImgTextPicLayout.this.ahi.boP(), MultiImgTextPicLayout.this.mFrom);
                } else if ("index".equals(MultiImgTextPicLayout.this.mFrom)) {
                    ay.a(MultiImgTextPicLayout.this.ahi, view.getContext(), 2, false);
                } else if ("frs".equals(MultiImgTextPicLayout.this.mFrom)) {
                    ay.a(MultiImgTextPicLayout.this.ahi, view.getContext(), 3, false);
                } else {
                    ay.a(view, MultiImgTextPicLayout.this.alQ, MultiImgTextPicLayout.this.amh, i, MultiImgTextPicLayout.this.ahi.boP(), MultiImgTextPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bz bzVar) {
        ArrayList<VoiceData.VoiceModel> brE = bzVar.brE();
        if (x.isEmpty(brE)) {
            this.amd.setVisibility(8);
            this.amg = false;
            return;
        }
        this.amd.setVisibility(0);
        VoiceData.VoiceModel voiceModel = brE.get(0);
        this.amd.setVoiceModel(voiceModel);
        this.amd.setTag(voiceModel);
        this.amd.bxO();
        if (voiceModel != null) {
            this.amd.EE(voiceModel.voice_status.intValue());
        }
        this.amd.cfr();
        this.amg = true;
    }

    private void setSingleImgData(bz bzVar) {
        MediaData mediaData;
        this.amo.setVisibility(8);
        this.amk.setVisibility(8);
        ArrayList<MediaData> brA = bzVar.brA();
        if (k.bov().isShowImages() && x.getCount(brA) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            MediaData mediaData2 = null;
            int i = 0;
            while (true) {
                if (i >= brA.size()) {
                    mediaData = mediaData2;
                    break;
                }
                mediaData2 = (MediaData) x.getItem(brA, i);
                if (mediaData2 == null || mediaData2.getType() != 3) {
                    i++;
                } else {
                    linkedList.add(mediaData2);
                    mediaData = mediaData2;
                    break;
                }
            }
            this.amh = linkedList;
            this.amf = true;
            this.amp.setVisibility(8);
            if (x.getCount(linkedList) == 1) {
                this.amp.setVisibility(0);
                a(mediaData, this.amp, false, false, 0);
                return;
            }
            this.amp.setVisibility(8);
            this.amf = false;
            return;
        }
        this.amp.setVisibility(8);
        this.amf = false;
    }

    private void setImageData(bz bzVar) {
        boolean z;
        ArrayList<MediaData> brA = bzVar.brA();
        if (k.bov().isShowImages() && x.getCount(brA) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < brA.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(brA, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.amh = linkedList;
            this.amf = true;
            if (linkedList.size() == 1) {
                this.amo.setVisibility(8);
                this.amk.setVisibility(8);
                this.amp.setVisibility(0);
                a((MediaData) x.getItem(brA, 0), this.amp, false, false, 0);
                return;
            }
            this.amp.setVisibility(8);
            b.m(this.amo, R.drawable.thread_card_more_number_bg);
            if (linkedList.size() > 3) {
                this.amo.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.amo.setVisibility(0);
                z = true;
            } else {
                this.amo.setVisibility(8);
                z = false;
            }
            this.amk.setVisibility(8);
            if (x.getCount(linkedList) == 2) {
                this.amk.setVisibility(0);
                a((MediaData) x.getItem(brA, 0), this.aml, z, false, 0);
                this.amm.setVisibility(8);
                a((MediaData) x.getItem(brA, 1), this.amn, z, false, 1);
                return;
            } else if (x.getCount(linkedList) >= 3) {
                this.amk.setVisibility(0);
                this.amm.setVisibility(0);
                a((MediaData) x.getItem(brA, 0), this.aml, z, false, 0);
                a((MediaData) x.getItem(brA, 1), this.amm, z, false, 1);
                a((MediaData) x.getItem(brA, 2), this.amn, z, true, 2);
                return;
            } else {
                this.amk.setVisibility(8);
                this.amf = false;
                return;
            }
        }
        this.amk.setVisibility(8);
        this.amf = false;
    }

    private void setImageTextData(bz bzVar) {
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        bz boP = aVar.boP();
        ay.a(this.mTitle, boP, this.ahF);
        ay.a(this.aia, this.mTitle, boP, ahY, this.ahF);
        setImageData(boP);
        setVoiceData(boP);
    }

    public void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public aa<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ajj;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ajj = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bG = bG(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aml.getLayoutParams();
        layoutParams.width = bG;
        layoutParams.height = bG;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.amm.getLayoutParams();
        layoutParams2.width = bG;
        layoutParams2.height = bG;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.amn.getLayoutParams();
        layoutParams3.width = bG;
        layoutParams3.height = bG;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.amo.getLayoutParams();
        layoutParams4.width = bG;
        layoutParams4.height = bG;
        if (this.amk.getVisibility() != 8) {
            this.aml.setLayoutParams(layoutParams);
            this.amm.setLayoutParams(layoutParams2);
            this.amn.setLayoutParams(layoutParams3);
            this.amo.setLayoutParams(layoutParams4);
        }
    }

    private int bG(int i) {
        if (this.amq > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.amq;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.amq = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.amq;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.alQ ? 13 : 14;
        if (!at.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        setCanCenterStart(false);
        boolean isLongPic = mediaData.isLongPic();
        boolean isSmartCrop = mediaData.isSmartCrop();
        tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
        tbImageView.setIsLongPic(isLongPic);
        tbImageView.setIsSmartCrop(isSmartCrop);
        tbImageView.setSmartCropCenterPointWidthRatio((float) mediaData.getSmartCropCenterPointWidthRatio());
        tbImageView.setSmartCropCenterPointHeightRatio((float) mediaData.getSmartCropCenterPointHeightRatio());
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(ao.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.alY);
        tbImageView.setPlaceHolder(2);
        if (z2 && z) {
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(false);
        } else {
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
        }
        tbImageView.startLoad(a2, i2, false);
        a(tbImageView, i, z, z2);
    }

    private String a(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            return mediaData.getSrc_pic();
        }
        return picUrl;
    }

    public void setCanCenterStart(boolean z) {
        this.ams = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.amr != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.amr == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private boolean amu;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.amu = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MultiImgTextPicLayout.this.amr != null) {
                MultiImgTextPicLayout.this.amr.c(view, this.currentIndex, this.hasMore && this.amu);
            }
        }
    }
}
