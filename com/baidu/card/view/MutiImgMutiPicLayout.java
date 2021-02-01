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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
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
/* loaded from: classes.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private boolean agD;
    public TextView agY;
    private com.baidu.tbadk.core.data.a agj;
    private ab<com.baidu.tbadk.core.data.a> aig;
    private boolean akO;
    private TbImageView.c akW;
    public PlayVoiceBntNew alb;
    private boolean ald;
    private boolean ale;
    private LinkedList<MediaData> alf;
    public RelativeLayout ali;
    public TbImageView alj;
    public TbImageView alk;
    public TbImageView alm;
    private TextView aln;
    private int alp;
    private d alq;
    protected boolean alr;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int akY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int akZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ala = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int agW = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akO = true;
        this.agj = null;
        this.ald = false;
        this.ale = false;
        this.alp = 0;
        this.alr = false;
        this.mLastScreenWidth = 0;
        this.agD = false;
        this.akW = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a Dk = c.bCP().Dk(com.baidu.adp.lib.e.d.mw().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.akO ? 13 : 14));
                    if (Dk != null) {
                        int width = Dk.getWidth();
                        i = Dk.getHeight();
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
                            if (MutiImgMutiPicLayout.this.alr && i > i2) {
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
        this.agY = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alb = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alb.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.agj);
                }
            }
        });
        int equipmentWidth = ((l.getEquipmentWidth(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X011) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002) * 2)) / 3;
        this.ali = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.ali.getLayoutParams().height = equipmentWidth;
        this.alj = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.alj.setDrawCorner(true);
        this.alj.setRadiusById(R.string.J_X12);
        this.alj.setPlaceHolder(2);
        this.alj.setConrers(15);
        this.alj.getLayoutParams().height = equipmentWidth;
        this.alj.getLayoutParams().width = equipmentWidth;
        this.alk = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.alk.setDrawCorner(false);
        this.alk.setPlaceHolder(2);
        this.alk.setRadiusById(R.string.J_X02);
        this.alk.setConrers(15);
        this.alk.getLayoutParams().height = equipmentWidth;
        this.alk.getLayoutParams().width = equipmentWidth;
        this.alm = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.alm.setDrawCorner(true);
        this.alm.setPlaceHolder(2);
        this.alm.setRadiusById(R.string.J_X11);
        this.alm.setConrers(15);
        this.alm.getLayoutParams().height = equipmentWidth;
        this.alm.getLayoutParams().width = equipmentWidth;
        this.aln = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.aln.getLayoutParams().height = equipmentWidth;
        this.aln.getLayoutParams().width = equipmentWidth;
        com.baidu.tbadk.core.elementsMaven.c.br(this.aln).oi(R.array.S_O_X001);
        this.aln.setTypeface(com.baidu.tbadk.core.elementsMaven.a.Az(com.baidu.tbadk.core.elementsMaven.a.getString(R.string.F_X02)));
        this.alq = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void c(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.agj.objType = 2;
                    subClickListener.ajn = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.agj);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fqu) {
                    az.a(view, MutiImgMutiPicLayout.this.akO, MutiImgMutiPicLayout.this.alf, i, MutiImgMutiPicLayout.this.agj.bln(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    az.a(MutiImgMutiPicLayout.this.agj, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    az.a(MutiImgMutiPicLayout.this.agj, view.getContext(), 3, false);
                } else {
                    az.a(view, MutiImgMutiPicLayout.this.akO, MutiImgMutiPicLayout.this.alf, i, MutiImgMutiPicLayout.this.agj.bln(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(cb cbVar) {
        ArrayList<VoiceData.VoiceModel> bod = cbVar.bod();
        if (y.isEmpty(bod)) {
            this.alb.setVisibility(8);
            this.ale = false;
            return;
        }
        this.alb.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bod.get(0);
        this.alb.setVoiceModel(voiceModel);
        this.alb.setTag(voiceModel);
        this.alb.buo();
        if (voiceModel != null) {
            this.alb.Dp(voiceModel.voice_status.intValue());
        }
        this.alb.ccu();
        this.ale = true;
    }

    private void setImageData(cb cbVar) {
        boolean z;
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        if (k.bkT().isShowImages() && y.getCount(bnZ) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bnZ.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bnZ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.alf = linkedList;
            this.ald = true;
            com.baidu.tbadk.core.elementsMaven.c.br(this.aln).og(R.string.J_X11).oe(R.array.Mask_X001);
            if (linkedList.size() > 3) {
                this.aln.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.aln.setVisibility(0);
                z = true;
            } else {
                this.aln.setVisibility(8);
                z = false;
            }
            this.ali.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.ali.setVisibility(0);
                a((MediaData) y.getItem(bnZ, 0), this.alj, z, false, 0);
                this.alk.setVisibility(8);
                a((MediaData) y.getItem(bnZ, 1), this.alm, z, false, 1);
                return;
            } else if (y.getCount(linkedList) >= 3) {
                this.ali.setVisibility(0);
                this.alk.setVisibility(0);
                a((MediaData) y.getItem(bnZ, 0), this.alj, z, false, 0);
                a((MediaData) y.getItem(bnZ, 1), this.alk, z, false, 1);
                a((MediaData) y.getItem(bnZ, 2), this.alm, z, true, 2);
                return;
            } else {
                this.ali.setVisibility(8);
                this.ald = false;
                return;
            }
        }
        this.ali.setVisibility(8);
        this.ald = false;
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.agj = aVar;
        cb bln = aVar.bln();
        az.a(this.mTitle, bln, this.agD);
        az.a(this.agY, this.mTitle, bln, agW, this.agD);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.agY == null || this.agY.getVisibility() != 0;
        RelativeLayout relativeLayout = this.ali;
        if (!z2 || !z3) {
            z = false;
        }
        az.a(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(bln);
        setVoiceData(bln);
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
        return this.aig;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aig = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alj.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.alk.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.alm.getLayoutParams();
        layoutParams3.width = bE;
        layoutParams3.height = bE;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.aln.getLayoutParams();
        layoutParams4.width = bE;
        layoutParams4.height = bE;
        if (this.ali.getVisibility() != 8) {
            this.alj.setLayoutParams(layoutParams);
            this.alk.setLayoutParams(layoutParams2);
            this.alm.setLayoutParams(layoutParams3);
            this.aln.setLayoutParams(layoutParams4);
        }
    }

    private int bE(int i) {
        if (this.alp > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.alp;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.alp = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3;
        return this.alp;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.akO ? 13 : 14;
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
        tbImageView.setOnDrawListener(this.akW);
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
        this.alr = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.alq != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.alq == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.agD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private boolean alt;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.alt = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.alq != null) {
                MutiImgMutiPicLayout.this.alq.c(view, this.currentIndex, this.hasMore && this.alt);
            }
        }
    }
}
