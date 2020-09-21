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
/* loaded from: classes20.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    public TextView afT;
    private AbsThreadDataSupport afq;
    private boolean ahR;
    private aa<AbsThreadDataSupport> ahd;
    private boolean ajR;
    private TbImageView.c ajZ;
    public PlayVoiceBntNew akd;
    private boolean akf;
    private boolean akg;
    private LinkedList<MediaData> akh;
    public RelativeLayout akk;
    public TbImageView akl;
    public TbImageView akm;
    public TbImageView akn;
    private TextView ako;
    private int akq;
    private d akr;
    protected boolean aks;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int akb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int afR = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajR = true;
        this.afq = null;
        this.akf = false;
        this.akg = false;
        this.akq = 0;
        this.aks = false;
        this.mLastScreenWidth = 0;
        this.ahR = false;
        this.ajZ = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a CI = c.bub().CI(com.baidu.adp.lib.e.c.mR().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.ajR ? 13 : 14));
                    if (CI != null) {
                        int width = CI.getWidth();
                        i = CI.getHeight();
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
                            if (MutiImgMutiPicLayout.this.aks && i > i2) {
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
        this.afT = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akd = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.afq);
                }
            }
        });
        int equipmentWidth = ((l.getEquipmentWidth(getContext()) - (al.ahm * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
        this.akk = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akk, R.dimen.tbds26, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.afT, R.dimen.tbds7, R.dimen.tbds10);
        this.akk.getLayoutParams().height = equipmentWidth;
        this.akl = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.akl.setDrawCorner(true);
        this.akl.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.akl.setPlaceHolder(2);
        this.akl.setConrers(15);
        this.akl.getLayoutParams().height = equipmentWidth;
        this.akl.getLayoutParams().width = equipmentWidth;
        this.akm = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.akm.setDrawCorner(false);
        this.akm.setPlaceHolder(2);
        this.akm.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.akm.setConrers(15);
        this.akm.getLayoutParams().height = equipmentWidth;
        this.akm.getLayoutParams().width = equipmentWidth;
        this.akn = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.akn.setDrawCorner(true);
        this.akn.setPlaceHolder(2);
        this.akn.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.akn.setConrers(15);
        this.akn.getLayoutParams().height = equipmentWidth;
        this.akn.getLayoutParams().width = equipmentWidth;
        this.ako = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.ako.getLayoutParams().height = equipmentWidth;
        this.ako.getLayoutParams().width = equipmentWidth;
        this.akr = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.afq.objType = 2;
                    subClickListener.aiq = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.afq);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().eCd) {
                    ay.a(view, MutiImgMutiPicLayout.this.ajR, MutiImgMutiPicLayout.this.akh, i, MutiImgMutiPicLayout.this.afq.bcY(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    ay.a(MutiImgMutiPicLayout.this.afq, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    ay.a(MutiImgMutiPicLayout.this.afq, view.getContext(), 3, false);
                } else {
                    ay.a(view, MutiImgMutiPicLayout.this.ajR, MutiImgMutiPicLayout.this.akh, i, MutiImgMutiPicLayout.this.afq.bcY(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> bfL = bwVar.bfL();
        if (y.isEmpty(bfL)) {
            this.akd.setVisibility(8);
            this.akg = false;
            return;
        }
        this.akd.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bfL.get(0);
        this.akd.setVoiceModel(voiceModel);
        this.akd.setTag(voiceModel);
        this.akd.changeSkin();
        if (voiceModel != null) {
            this.akd.Cn(voiceModel.voice_status.intValue());
        }
        this.akd.bQr();
        this.akg = true;
    }

    private void setImageData(bw bwVar) {
        boolean z;
        ArrayList<MediaData> bfH = bwVar.bfH();
        if (k.bcG().isShowImages() && y.getCount(bfH) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bfH.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bfH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.akh = linkedList;
            this.akf = true;
            com.baidu.tbadk.a.b.a.h(this.ako, R.drawable.thread_card_more_number_bg);
            if (linkedList.size() > 3) {
                this.ako.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.ako.setVisibility(0);
                z = true;
            } else {
                this.ako.setVisibility(8);
                z = false;
            }
            this.akk.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.akk.setVisibility(0);
                a((MediaData) y.getItem(bfH, 0), this.akl, z, false, 0);
                this.akm.setVisibility(8);
                a((MediaData) y.getItem(bfH, 1), this.akn, z, false, 1);
                return;
            } else if (y.getCount(linkedList) >= 3) {
                this.akk.setVisibility(0);
                this.akm.setVisibility(0);
                a((MediaData) y.getItem(bfH, 0), this.akl, z, false, 0);
                a((MediaData) y.getItem(bfH, 1), this.akm, z, false, 1);
                a((MediaData) y.getItem(bfH, 2), this.akn, z, true, 2);
                return;
            } else {
                this.akk.setVisibility(8);
                this.akf = false;
                return;
            }
        }
        this.akk.setVisibility(8);
        this.akf = false;
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        bw bcY = absThreadDataSupport.bcY();
        ay.a(this.mTitle, bcY, this.ahR);
        ay.a(this.afT, this.mTitle, bcY, afR, this.ahR);
        setImageData(bcY);
        setVoiceData(bcY);
        ua();
    }

    private void ua() {
        if (this.afT.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.akf) {
                setMarginsTop(this.akd, akb);
            } else if (this.akg) {
                setMarginsTop(this.akd, akc);
            }
        } else if (this.akd != null && this.akd.getLayoutParams() != null) {
            if (this.akf) {
                setMarginsTop(this.akd, akb);
            } else if (this.akg) {
                setMarginsTop(this.akd, afY);
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
        return this.ahd;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahd = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akl.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akm.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.akn.getLayoutParams();
        layoutParams3.width = bE;
        layoutParams3.height = bE;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.ako.getLayoutParams();
        layoutParams4.width = bE;
        layoutParams4.height = bE;
        if (this.akk.getVisibility() != 8) {
            this.akl.setLayoutParams(layoutParams);
            this.akm.setLayoutParams(layoutParams2);
            this.akn.setLayoutParams(layoutParams3);
            this.ako.setLayoutParams(layoutParams4);
        }
    }

    private int bE(int i) {
        if (this.akq > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.akq;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.akq = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.akq;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.ajR ? 13 : 14;
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
        tbImageView.setOnDrawListener(this.ajZ);
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
        this.aks = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.akr != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.akr == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private boolean aku;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aku = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.akr != null) {
                MutiImgMutiPicLayout.this.akr.b(view, this.currentIndex, this.hasMore && this.aku);
            }
        }
    }
}
