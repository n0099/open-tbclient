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
import com.baidu.adp.widget.a.b;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
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
public class MutiImgMutiPicLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private boolean agO;
    private com.baidu.tbadk.core.data.a agr;
    public TextView ahj;
    private aa<com.baidu.tbadk.core.data.a> ais;
    private boolean akY;
    private d alA;
    protected boolean alB;
    private TbImageView.c alg;
    public PlayVoiceBntNew alm;
    private boolean alo;
    private boolean alp;
    private LinkedList<MediaData> alq;
    public RelativeLayout alt;
    public TbImageView alu;
    public TbImageView alv;
    public TbImageView alw;
    private TextView alx;
    private int alz;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int ali = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int alj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int alk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int ahh = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akY = true;
        this.agr = null;
        this.alo = false;
        this.alp = false;
        this.alz = 0;
        this.alB = false;
        this.mLastScreenWidth = 0;
        this.agO = false;
        this.alg = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a CT = c.bCx().CT(com.baidu.adp.lib.e.d.mx().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.akY ? 13 : 14));
                    if (CT != null) {
                        int width = CT.getWidth();
                        i = CT.getHeight();
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
                            if (MutiImgMutiPicLayout.this.alB && i > i2) {
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
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahj = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alm = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alm.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.agr);
                }
            }
        });
        int equipmentWidth = ((l.getEquipmentWidth(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X011) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002) * 2)) / 3;
        this.alt = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.alt.getLayoutParams().height = equipmentWidth;
        this.alu = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.alu.setDrawCorner(true);
        this.alu.setRadiusById(R.string.J_X12);
        this.alu.setPlaceHolder(2);
        this.alu.setConrers(15);
        this.alu.getLayoutParams().height = equipmentWidth;
        this.alu.getLayoutParams().width = equipmentWidth;
        this.alv = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.alv.setDrawCorner(false);
        this.alv.setPlaceHolder(2);
        this.alv.setRadiusById(R.string.J_X02);
        this.alv.setConrers(15);
        this.alv.getLayoutParams().height = equipmentWidth;
        this.alv.getLayoutParams().width = equipmentWidth;
        this.alw = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.alw.setDrawCorner(true);
        this.alw.setPlaceHolder(2);
        this.alw.setRadiusById(R.string.J_X11);
        this.alw.setConrers(15);
        this.alw.getLayoutParams().height = equipmentWidth;
        this.alw.getLayoutParams().width = equipmentWidth;
        this.alx = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.alx.getLayoutParams().height = equipmentWidth;
        this.alx.getLayoutParams().width = equipmentWidth;
        float[] nL = com.baidu.tbadk.core.elementsMaven.a.nL(R.array.S_O_X001);
        this.alx.setShadowLayer(nL[1], nL[2], nL[3], (int) nL[0]);
        this.alx.setTypeface(com.baidu.tbadk.core.elementsMaven.a.Ai(com.baidu.tbadk.core.elementsMaven.a.getString(R.string.F_X02)));
        this.alA = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void c(View view, int i, boolean z) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.agr.objType = 2;
                    subClickListener.ajy = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.agr);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fob) {
                    ay.a(view, MutiImgMutiPicLayout.this.akY, MutiImgMutiPicLayout.this.alq, i, MutiImgMutiPicLayout.this.agr.bkV(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    ay.a(MutiImgMutiPicLayout.this.agr, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    ay.a(MutiImgMutiPicLayout.this.agr, view.getContext(), 3, false);
                } else {
                    ay.a(view, MutiImgMutiPicLayout.this.akY, MutiImgMutiPicLayout.this.alq, i, MutiImgMutiPicLayout.this.agr.bkV(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bz bzVar) {
        ArrayList<VoiceData.VoiceModel> bnK = bzVar.bnK();
        if (x.isEmpty(bnK)) {
            this.alm.setVisibility(8);
            this.alp = false;
            return;
        }
        this.alm.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bnK.get(0);
        this.alm.setVoiceModel(voiceModel);
        this.alm.setTag(voiceModel);
        this.alm.btU();
        if (voiceModel != null) {
            this.alm.CY(voiceModel.voice_status.intValue());
        }
        this.alm.cbz();
        this.alp = true;
    }

    private void setImageData(bz bzVar) {
        boolean z;
        ArrayList<MediaData> bnG = bzVar.bnG();
        if (k.bkB().isShowImages() && x.getCount(bnG) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bnG.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(bnG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.alq = linkedList;
            this.alo = true;
            com.baidu.tbadk.core.elementsMaven.c.bv(this.alx).od(R.string.J_X11).ob(R.array.Mask_X001);
            if (linkedList.size() > 3) {
                this.alx.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.alx.setVisibility(0);
                z = true;
            } else {
                this.alx.setVisibility(8);
                z = false;
            }
            this.alt.setVisibility(8);
            if (x.getCount(linkedList) == 2) {
                this.alt.setVisibility(0);
                a((MediaData) x.getItem(bnG, 0), this.alu, z, false, 0);
                this.alv.setVisibility(8);
                a((MediaData) x.getItem(bnG, 1), this.alw, z, false, 1);
                return;
            } else if (x.getCount(linkedList) >= 3) {
                this.alt.setVisibility(0);
                this.alv.setVisibility(0);
                a((MediaData) x.getItem(bnG, 0), this.alu, z, false, 0);
                a((MediaData) x.getItem(bnG, 1), this.alv, z, false, 1);
                a((MediaData) x.getItem(bnG, 2), this.alw, z, true, 2);
                return;
            } else {
                this.alt.setVisibility(8);
                this.alo = false;
                return;
            }
        }
        this.alt.setVisibility(8);
        this.alo = false;
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.agr = aVar;
        bz bkV = aVar.bkV();
        ay.a(this.mTitle, bkV, this.agO);
        ay.a(this.ahj, this.mTitle, bkV, ahh, this.agO);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.ahj == null || this.ahj.getVisibility() != 0;
        RelativeLayout relativeLayout = this.alt;
        if (!z2 || !z3) {
            z = false;
        }
        ay.a(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(bkV);
        setVoiceData(bkV);
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
        return this.ais;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ais = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alu.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.alv.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.alw.getLayoutParams();
        layoutParams3.width = bE;
        layoutParams3.height = bE;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.alx.getLayoutParams();
        layoutParams4.width = bE;
        layoutParams4.height = bE;
        if (this.alt.getVisibility() != 8) {
            this.alu.setLayoutParams(layoutParams);
            this.alv.setLayoutParams(layoutParams2);
            this.alw.setLayoutParams(layoutParams3);
            this.alx.setLayoutParams(layoutParams4);
        }
    }

    private int bE(int i) {
        if (this.alz > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.alz;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.alz = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3;
        return this.alz;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.akY ? 13 : 14;
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
        tbImageView.setOnDrawListener(this.alg);
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
        this.alB = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.alA != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.alA == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.agO = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private boolean alD;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.alD = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.alA != null) {
                MutiImgMutiPicLayout.this.alA.c(view, this.currentIndex, this.hasMore && this.alD);
            }
        }
    }
}
