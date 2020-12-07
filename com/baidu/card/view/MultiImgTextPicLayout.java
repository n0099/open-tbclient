package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.a.b;
import com.baidu.card.al;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class MultiImgTextPicLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int ahn;
    private com.baidu.tbadk.core.data.a agJ;
    public TextView ahp;
    private ab<com.baidu.tbadk.core.data.a> aix;
    private boolean ajm;
    public PlayVoiceBntNew alB;
    private boolean alD;
    private boolean alE;
    private LinkedList<MediaData> alF;
    public RelativeLayout alI;
    public TbImageView alJ;
    public TbImageView alK;
    public TbImageView alL;
    private TextView alM;
    public TbImageView alN;
    private int alO;
    private d alP;
    protected boolean alQ;
    private boolean alo;
    private TbImageView.b alw;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int aly = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int alz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int alA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    static {
        ahn = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bkA() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgTextPicLayout(Context context) {
        this(context, null);
    }

    public MultiImgTextPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alo = true;
        this.agJ = null;
        this.alD = false;
        this.alE = false;
        this.alO = 0;
        this.alQ = false;
        this.mLastScreenWidth = 0;
        this.ajm = false;
        this.alw = new TbImageView.b() { // from class: com.baidu.card.view.MultiImgTextPicLayout.3
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                float f7 = 0.0f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ei = c.bDV().Ei(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), MultiImgTextPicLayout.this.alo ? 13 : 14));
                    if (Ei != null) {
                        int width = Ei.getWidth();
                        i = Ei.getHeight();
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
                                float f8 = i2 * smartCropCenterPointWidthRatio * f5;
                                if (f8 < width2 * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i2 * f5) - f8 < width2 * 0.5f) {
                                    f6 = width2 - (i2 * f5);
                                } else {
                                    f6 = (width2 * 0.5f) - f8;
                                }
                            } else {
                                f5 = width2 / i2;
                                float f9 = i * smartCropCenterPointHeightRatio * f5;
                                if (f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i * f5) - f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = height - (i * f5);
                                } else {
                                    float f10 = (height * 0.5f) - f9;
                                    f6 = 0.0f;
                                    f7 = f10;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f6, f7);
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
                                float f11 = height / i;
                                f2 = f11;
                                f3 = (width2 - (i2 * f11)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f12 = width2 / i2;
                                f = (height - (i * f12)) * 0.5f;
                                f2 = f12;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (MultiImgTextPicLayout.this.alQ && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_card_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahp = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alB = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgTextPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgTextPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgTextPicLayout.this.agJ);
                }
            }
        });
        int equipmentWidth = ((l.getEquipmentWidth(getContext()) - (al.aiG * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
        this.alI = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.alI, R.dimen.tbds26, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.ahp, R.dimen.tbds7, R.dimen.tbds10);
        this.alI.getLayoutParams().height = equipmentWidth;
        this.alJ = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.alJ.setDrawCorner(true);
        this.alJ.setRadiusById(R.string.J_X12);
        this.alJ.setPlaceHolder(2);
        this.alJ.setConrers(15);
        this.alJ.getLayoutParams().height = equipmentWidth;
        this.alJ.getLayoutParams().width = equipmentWidth;
        this.alK = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.alK.setDrawCorner(false);
        this.alK.setPlaceHolder(2);
        this.alK.setRadiusById(R.string.J_X02);
        this.alK.setConrers(15);
        this.alK.getLayoutParams().height = equipmentWidth;
        this.alK.getLayoutParams().width = equipmentWidth;
        this.alL = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.alL.setDrawCorner(true);
        this.alL.setPlaceHolder(2);
        this.alL.setRadiusById(R.string.J_X11);
        this.alL.setConrers(15);
        this.alL.getLayoutParams().height = equipmentWidth;
        this.alL.getLayoutParams().width = equipmentWidth;
        this.alM = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.alM.getLayoutParams().height = equipmentWidth;
        this.alM.getLayoutParams().width = equipmentWidth;
        float[] ph = com.baidu.tbadk.core.elementsMaven.a.ph(R.array.S_O_X001);
        this.alM.setShadowLayer(ph[1], ph[2], ph[3], (int) ph[0]);
        this.alM.setTypeface(com.baidu.tbadk.core.elementsMaven.a.Bv(com.baidu.tbadk.core.elementsMaven.a.getString(R.string.F_X02)));
        this.alN = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.alN.setRadiusById(R.string.J_X05);
        this.alN.setConrers(15);
        this.alN.setDrawCorner(true);
        this.alN.setPlaceHolder(3);
        this.alN.setLongIconSupport(true);
        this.alN.setGifIconSupport(true);
        com.baidu.tbadk.a.b.a.d(this.alN, R.dimen.tbds28, R.dimen.tbds14);
        this.alP = new d() { // from class: com.baidu.card.view.MultiImgTextPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgTextPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MultiImgTextPicLayout.this.agJ.objType = 2;
                    subClickListener.ajN = Boolean.valueOf(z);
                    subClickListener.a(view, MultiImgTextPicLayout.this.agJ);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fjd) {
                    az.a(view, MultiImgTextPicLayout.this.alo, MultiImgTextPicLayout.this.alF, i, MultiImgTextPicLayout.this.agJ.bmn(), MultiImgTextPicLayout.this.mFrom);
                } else if ("index".equals(MultiImgTextPicLayout.this.mFrom)) {
                    az.a(MultiImgTextPicLayout.this.agJ, view.getContext(), 2, false);
                } else if ("frs".equals(MultiImgTextPicLayout.this.mFrom)) {
                    az.a(MultiImgTextPicLayout.this.agJ, view.getContext(), 3, false);
                } else {
                    az.a(view, MultiImgTextPicLayout.this.alo, MultiImgTextPicLayout.this.alF, i, MultiImgTextPicLayout.this.agJ.bmn(), MultiImgTextPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(by byVar) {
        ArrayList<VoiceData.VoiceModel> bpc = byVar.bpc();
        if (y.isEmpty(bpc)) {
            this.alB.setVisibility(8);
            this.alE = false;
            return;
        }
        this.alB.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bpc.get(0);
        this.alB.setVoiceModel(voiceModel);
        this.alB.setTag(voiceModel);
        this.alB.bvs();
        if (voiceModel != null) {
            this.alB.EM(voiceModel.voice_status.intValue());
        }
        this.alB.ccz();
        this.alE = true;
    }

    private void setSingleImgData(by byVar) {
        MediaData mediaData;
        this.alM.setVisibility(8);
        this.alI.setVisibility(8);
        ArrayList<MediaData> boY = byVar.boY();
        if (k.blV().isShowImages() && y.getCount(boY) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            MediaData mediaData2 = null;
            int i = 0;
            while (true) {
                if (i >= boY.size()) {
                    mediaData = mediaData2;
                    break;
                }
                mediaData2 = (MediaData) y.getItem(boY, i);
                if (mediaData2 == null || mediaData2.getType() != 3) {
                    i++;
                } else {
                    linkedList.add(mediaData2);
                    mediaData = mediaData2;
                    break;
                }
            }
            this.alF = linkedList;
            this.alD = true;
            this.alN.setVisibility(8);
            if (y.getCount(linkedList) == 1) {
                this.alN.setVisibility(0);
                a(mediaData, this.alN, false, false, 0);
                return;
            }
            this.alN.setVisibility(8);
            this.alD = false;
            return;
        }
        this.alN.setVisibility(8);
        this.alD = false;
    }

    private void setImageData(by byVar) {
        boolean z;
        ArrayList<MediaData> boY = byVar.boY();
        if (k.blV().isShowImages() && y.getCount(boY) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < boY.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(boY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.alF = linkedList;
            this.alD = true;
            if (linkedList.size() == 1) {
                this.alM.setVisibility(8);
                this.alI.setVisibility(8);
                this.alN.setVisibility(0);
                a((MediaData) y.getItem(boY, 0), this.alN, false, false, 0);
                return;
            }
            this.alN.setVisibility(8);
            com.baidu.tbadk.a.b.a.j(this.alM, R.drawable.thread_card_more_number_bg);
            if (linkedList.size() > 3) {
                this.alM.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.alM.setVisibility(0);
                z = true;
            } else {
                this.alM.setVisibility(8);
                z = false;
            }
            this.alI.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.alI.setVisibility(0);
                a((MediaData) y.getItem(boY, 0), this.alJ, z, false, 0);
                this.alK.setVisibility(8);
                a((MediaData) y.getItem(boY, 1), this.alL, z, false, 1);
                return;
            } else if (y.getCount(linkedList) >= 3) {
                this.alI.setVisibility(0);
                this.alK.setVisibility(0);
                a((MediaData) y.getItem(boY, 0), this.alJ, z, false, 0);
                a((MediaData) y.getItem(boY, 1), this.alK, z, false, 1);
                a((MediaData) y.getItem(boY, 2), this.alL, z, true, 2);
                return;
            } else {
                this.alI.setVisibility(8);
                this.alD = false;
                return;
            }
        }
        this.alI.setVisibility(8);
        this.alD = false;
    }

    private void setImageTextData(by byVar) {
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        by bmn = aVar.bmn();
        az.a(this.mTitle, bmn, this.ajm);
        az.a(this.ahp, this.mTitle, bmn, ahn, this.ajm);
        setImageData(bmn);
        setVoiceData(bmn);
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

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.aix;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aix = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bG = bG(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alJ.getLayoutParams();
        layoutParams.width = bG;
        layoutParams.height = bG;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.alK.getLayoutParams();
        layoutParams2.width = bG;
        layoutParams2.height = bG;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.alL.getLayoutParams();
        layoutParams3.width = bG;
        layoutParams3.height = bG;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.alM.getLayoutParams();
        layoutParams4.width = bG;
        layoutParams4.height = bG;
        if (this.alI.getVisibility() != 8) {
            this.alJ.setLayoutParams(layoutParams);
            this.alK.setLayoutParams(layoutParams2);
            this.alL.setLayoutParams(layoutParams3);
            this.alM.setLayoutParams(layoutParams4);
        }
    }

    private int bG(int i) {
        if (this.alO > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.alO;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.alO = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.alO;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.alo ? 13 : 14;
        if (!au.equals(a2, tbImageView.getUrl())) {
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
        tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.alw);
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
        this.alQ = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.alP != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.alP == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ajm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private boolean alS;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.alS = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MultiImgTextPicLayout.this.alP != null) {
                MultiImgTextPicLayout.this.alP.b(view, this.currentIndex, this.hasMore && this.alS);
            }
        }
    }
}
