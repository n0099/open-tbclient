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
import com.baidu.card.ak;
import com.baidu.card.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes15.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements o<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeY;
    public TextView afB;
    private aa<AbsThreadDataSupport> agK;
    private boolean ahx;
    private TbImageView.c ajB;
    public PlayVoiceBntNew ajF;
    private boolean ajH;
    private boolean ajI;
    private LinkedList<MediaData> ajJ;
    private int ajP;
    private d ajQ;
    public RelativeLayout ajT;
    public TbImageView ajU;
    public TbImageView ajV;
    public TbImageView ajW;
    private TextView ajY;
    protected boolean ajZ;
    private boolean ajt;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int ajD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ajE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int afz = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajt = true;
        this.aeY = null;
        this.ajH = false;
        this.ajI = false;
        this.ajP = 0;
        this.ajZ = false;
        this.mLastScreenWidth = 0;
        this.ahx = false;
        this.ajB = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                float f7 = 0.0f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Cm = c.bsX().Cm(com.baidu.adp.lib.e.c.mM().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.ajt ? 13 : 14));
                    if (Cm != null) {
                        int width = Cm.getWidth();
                        i = Cm.getHeight();
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
                            if (MutiImgMutiPicLayout.this.ajZ && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
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
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ajF = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ajF.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.aeY);
                }
            }
        });
        int equipmentWidth = ((l.getEquipmentWidth(getContext()) - (ak.agT * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
        this.ajT = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.ajT, R.dimen.tbds26, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.afB, R.dimen.tbds7, R.dimen.tbds10);
        this.ajT.getLayoutParams().height = equipmentWidth;
        this.ajU = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.ajU.setDrawCorner(true);
        this.ajU.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ajU.setPlaceHolder(2);
        this.ajU.setConrers(15);
        this.ajU.getLayoutParams().height = equipmentWidth;
        this.ajU.getLayoutParams().width = equipmentWidth;
        this.ajV = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.ajV.setDrawCorner(false);
        this.ajV.setPlaceHolder(2);
        this.ajV.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ajV.setConrers(15);
        this.ajV.getLayoutParams().height = equipmentWidth;
        this.ajV.getLayoutParams().width = equipmentWidth;
        this.ajW = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.ajW.setDrawCorner(true);
        this.ajW.setPlaceHolder(2);
        this.ajW.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ajW.setConrers(15);
        this.ajW.getLayoutParams().height = equipmentWidth;
        this.ajW.getLayoutParams().width = equipmentWidth;
        this.ajY = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.ajY.getLayoutParams().height = equipmentWidth;
        this.ajY.getLayoutParams().width = equipmentWidth;
        this.ajQ = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.aeY.objType = 2;
                    subClickListener.ahV = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.aeY);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().ezZ) {
                    ay.a(view, MutiImgMutiPicLayout.this.ajt, MutiImgMutiPicLayout.this.ajJ, i, MutiImgMutiPicLayout.this.aeY.bce(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    ay.a(MutiImgMutiPicLayout.this.aeY, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    ay.a(MutiImgMutiPicLayout.this.aeY, view.getContext(), 3, false);
                } else {
                    ay.a(view, MutiImgMutiPicLayout.this.ajt, MutiImgMutiPicLayout.this.ajJ, i, MutiImgMutiPicLayout.this.aeY.bce(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> beR = bwVar.beR();
        if (y.isEmpty(beR)) {
            this.ajF.setVisibility(8);
            this.ajI = false;
            return;
        }
        this.ajF.setVisibility(0);
        VoiceData.VoiceModel voiceModel = beR.get(0);
        this.ajF.setVoiceModel(voiceModel);
        this.ajF.setTag(voiceModel);
        this.ajF.changeSkin();
        if (voiceModel != null) {
            this.ajF.BM(voiceModel.voice_status.intValue());
        }
        this.ajF.bPf();
        this.ajI = true;
    }

    private void setImageData(bw bwVar) {
        boolean z;
        ArrayList<MediaData> beN = bwVar.beN();
        if (k.bbM().isShowImages() && y.getCount(beN) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < beN.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(beN, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.ajJ = linkedList;
            this.ajH = true;
            com.baidu.tbadk.a.b.a.h(this.ajY, R.drawable.thread_card_more_number_bg);
            if (linkedList.size() > 3) {
                this.ajY.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.ajY.setVisibility(0);
                z = true;
            } else {
                this.ajY.setVisibility(8);
                z = false;
            }
            this.ajT.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.ajT.setVisibility(0);
                a((MediaData) y.getItem(beN, 0), this.ajU, z, false, 0);
                this.ajV.setVisibility(8);
                a((MediaData) y.getItem(beN, 1), this.ajW, z, false, 1);
                return;
            } else if (y.getCount(linkedList) >= 3) {
                this.ajT.setVisibility(0);
                this.ajV.setVisibility(0);
                a((MediaData) y.getItem(beN, 0), this.ajU, z, false, 0);
                a((MediaData) y.getItem(beN, 1), this.ajV, z, false, 1);
                a((MediaData) y.getItem(beN, 2), this.ajW, z, true, 2);
                return;
            } else {
                this.ajT.setVisibility(8);
                this.ajH = false;
                return;
            }
        }
        this.ajT.setVisibility(8);
        this.ajH = false;
    }

    public void setFromCDN(boolean z) {
        this.ajt = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        ay.a(this.mTitle, bce, this.ahx);
        ay.a(this.afB, this.mTitle, bce, afz, this.ahx);
        setImageData(bce);
        setVoiceData(bce);
        tU();
    }

    private void tU() {
        if (this.afB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ajH) {
                setMarginsTop(this.ajF, ajD);
            } else if (this.ajI) {
                setMarginsTop(this.ajF, ajE);
            }
        } else if (this.ajF != null && this.ajF.getLayoutParams() != null) {
            if (this.ajH) {
                setMarginsTop(this.ajF, ajD);
            } else if (this.ajI) {
                setMarginsTop(this.ajF, afG);
            }
        }
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

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.agK;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.agK = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bA = bA(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajU.getLayoutParams();
        layoutParams.width = bA;
        layoutParams.height = bA;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajV.getLayoutParams();
        layoutParams2.width = bA;
        layoutParams2.height = bA;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ajW.getLayoutParams();
        layoutParams3.width = bA;
        layoutParams3.height = bA;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.ajY.getLayoutParams();
        layoutParams4.width = bA;
        layoutParams4.height = bA;
        if (this.ajT.getVisibility() != 8) {
            this.ajU.setLayoutParams(layoutParams);
            this.ajV.setLayoutParams(layoutParams2);
            this.ajW.setLayoutParams(layoutParams3);
            this.ajY.setLayoutParams(layoutParams4);
        }
    }

    private int bA(int i) {
        if (this.ajP > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.ajP;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ajP = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.ajP;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.ajt ? 13 : 14;
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
        tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.ajB);
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
        this.ajZ = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.ajQ != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.ajQ == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private boolean ajS;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.ajS = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.ajQ != null) {
                MutiImgMutiPicLayout.this.ajQ.b(view, this.currentIndex, this.hasMore && this.ajS);
            }
        }
    }
}
