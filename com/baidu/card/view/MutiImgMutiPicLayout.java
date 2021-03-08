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
    private com.baidu.tbadk.core.data.a ahB;
    private boolean ahV;
    public TextView air;
    private ab<com.baidu.tbadk.core.data.a> ajy;
    public RelativeLayout amB;
    public TbImageView amC;
    public TbImageView amD;
    public TbImageView amE;
    private TextView amF;
    private int amH;
    private d amI;
    protected boolean amJ;
    private boolean amh;
    private TbImageView.c amp;
    public PlayVoiceBntNew amu;
    private boolean amw;
    private boolean amx;
    private LinkedList<MediaData> amy;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int amr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int ams = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int amt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int aip = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amh = true;
        this.ahB = null;
        this.amw = false;
        this.amx = false;
        this.amH = 0;
        this.amJ = false;
        this.mLastScreenWidth = 0;
        this.ahV = false;
        this.amp = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a Dp = c.bCS().Dp(com.baidu.adp.lib.e.d.mw().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.amh ? 13 : 14));
                    if (Dp != null) {
                        int width = Dp.getWidth();
                        i = Dp.getHeight();
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
                            if (MutiImgMutiPicLayout.this.amJ && i > i2) {
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
        this.air = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.amu = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.amu.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.ahB);
                }
            }
        });
        int equipmentWidth = ((l.getEquipmentWidth(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X011) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002) * 2)) / 3;
        this.amB = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.amB.getLayoutParams().height = equipmentWidth;
        this.amC = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.amC.setDrawCorner(true);
        this.amC.setRadiusById(R.string.J_X12);
        this.amC.setPlaceHolder(2);
        this.amC.setConrers(15);
        this.amC.getLayoutParams().height = equipmentWidth;
        this.amC.getLayoutParams().width = equipmentWidth;
        this.amD = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.amD.setDrawCorner(false);
        this.amD.setPlaceHolder(2);
        this.amD.setRadiusById(R.string.J_X02);
        this.amD.setConrers(15);
        this.amD.getLayoutParams().height = equipmentWidth;
        this.amD.getLayoutParams().width = equipmentWidth;
        this.amE = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.amE.setDrawCorner(true);
        this.amE.setPlaceHolder(2);
        this.amE.setRadiusById(R.string.J_X11);
        this.amE.setConrers(15);
        this.amE.getLayoutParams().height = equipmentWidth;
        this.amE.getLayoutParams().width = equipmentWidth;
        this.amF = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.amF.getLayoutParams().height = equipmentWidth;
        this.amF.getLayoutParams().width = equipmentWidth;
        com.baidu.tbadk.core.elementsMaven.c.br(this.amF).oj(R.array.S_O_X001);
        this.amF.setTypeface(com.baidu.tbadk.core.elementsMaven.a.AG(com.baidu.tbadk.core.elementsMaven.a.getString(R.string.F_X02)));
        this.amI = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void c(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.ahB.objType = 2;
                    subClickListener.akF = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.ahB);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().frV) {
                    az.a(view, MutiImgMutiPicLayout.this.amh, MutiImgMutiPicLayout.this.amy, i, MutiImgMutiPicLayout.this.ahB.blp(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    az.a(MutiImgMutiPicLayout.this.ahB, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    az.a(MutiImgMutiPicLayout.this.ahB, view.getContext(), 3, false);
                } else {
                    az.a(view, MutiImgMutiPicLayout.this.amh, MutiImgMutiPicLayout.this.amy, i, MutiImgMutiPicLayout.this.ahB.blp(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(cb cbVar) {
        ArrayList<VoiceData.VoiceModel> bof = cbVar.bof();
        if (y.isEmpty(bof)) {
            this.amu.setVisibility(8);
            this.amx = false;
            return;
        }
        this.amu.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bof.get(0);
        this.amu.setVoiceModel(voiceModel);
        this.amu.setTag(voiceModel);
        this.amu.bur();
        if (voiceModel != null) {
            this.amu.Ds(voiceModel.voice_status.intValue());
        }
        this.amu.ccH();
        this.amx = true;
    }

    private void setImageData(cb cbVar) {
        boolean z;
        ArrayList<MediaData> bob = cbVar.bob();
        if (k.bkV().isShowImages() && y.getCount(bob) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bob.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bob, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.amy = linkedList;
            this.amw = true;
            com.baidu.tbadk.core.elementsMaven.c.br(this.amF).oh(R.string.J_X11).of(R.array.Mask_X001);
            if (linkedList.size() > 3) {
                this.amF.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.amF.setVisibility(0);
                z = true;
            } else {
                this.amF.setVisibility(8);
                z = false;
            }
            this.amB.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.amB.setVisibility(0);
                a((MediaData) y.getItem(bob, 0), this.amC, z, false, 0);
                this.amD.setVisibility(8);
                a((MediaData) y.getItem(bob, 1), this.amE, z, false, 1);
                return;
            } else if (y.getCount(linkedList) >= 3) {
                this.amB.setVisibility(0);
                this.amD.setVisibility(0);
                a((MediaData) y.getItem(bob, 0), this.amC, z, false, 0);
                a((MediaData) y.getItem(bob, 1), this.amD, z, false, 1);
                a((MediaData) y.getItem(bob, 2), this.amE, z, true, 2);
                return;
            } else {
                this.amB.setVisibility(8);
                this.amw = false;
                return;
            }
        }
        this.amB.setVisibility(8);
        this.amw = false;
    }

    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.ahB = aVar;
        cb blp = aVar.blp();
        az.a(this.mTitle, blp, this.ahV);
        az.a(this.air, this.mTitle, blp, aip, this.ahV);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.air == null || this.air.getVisibility() != 0;
        RelativeLayout relativeLayout = this.amB;
        if (!z2 || !z3) {
            z = false;
        }
        az.a(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(blp);
        setVoiceData(blp);
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
        return this.ajy;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ajy = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bF = bF(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.amC.getLayoutParams();
        layoutParams.width = bF;
        layoutParams.height = bF;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.amD.getLayoutParams();
        layoutParams2.width = bF;
        layoutParams2.height = bF;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.amE.getLayoutParams();
        layoutParams3.width = bF;
        layoutParams3.height = bF;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.amF.getLayoutParams();
        layoutParams4.width = bF;
        layoutParams4.height = bF;
        if (this.amB.getVisibility() != 8) {
            this.amC.setLayoutParams(layoutParams);
            this.amD.setLayoutParams(layoutParams2);
            this.amE.setLayoutParams(layoutParams3);
            this.amF.setLayoutParams(layoutParams4);
        }
    }

    private int bF(int i) {
        if (this.amH > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.amH;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.amH = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3;
        return this.amH;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.amh ? 13 : 14;
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
        tbImageView.setOnDrawListener(this.amp);
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
        this.amJ = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.amI != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.amI == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private boolean amL;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.amL = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.amI != null) {
                MutiImgMutiPicLayout.this.amI.c(view, this.currentIndex, this.hasMore && this.amL);
            }
        }
    }
}
