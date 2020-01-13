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
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a JH;
    public TextView Kf;
    private z<com.baidu.tbadk.core.data.a> Lh;
    private LinkedList<MediaData> NB;
    private int NH;
    private d NI;
    public RelativeLayout NL;
    public TbImageView NM;
    public TbImageView NN;
    public TbImageView NP;
    private TextView NR;
    protected boolean NT;
    private boolean Nj;
    private TbImageView.c Nr;
    public PlayVoiceBntNew Nw;
    private boolean Ny;
    private boolean Nz;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int Nt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Nu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Nv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Kc = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nj = true;
        this.JH = null;
        this.Ny = false;
        this.Nz = false;
        this.NH = 0;
        this.NT = false;
        this.mLastScreenWidth = 0;
        this.Nr = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a vg = c.aNs().vg(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.Nj ? 13 : 14));
                    if (vg != null) {
                        int width = vg.getWidth();
                        i = vg.getHeight();
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
                            if (MutiImgMutiPicLayout.this.NT && i > i2) {
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
        this.Kf = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Nw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Nw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.JH);
                }
            }
        });
        this.NL = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.NM = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.NM.setDrawCorner(true);
        this.NM.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.NM.setPlaceHolder(2);
        this.NM.setConrers(15);
        this.NN = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.NN.setDrawCorner(false);
        this.NN.setPlaceHolder(2);
        this.NN.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.NN.setConrers(15);
        this.NP = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.NP.setDrawCorner(true);
        this.NP.setPlaceHolder(2);
        this.NP.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.NP.setConrers(15);
        this.NR = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.NI = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.JH.objType = 2;
                    subClickListener.Ms = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.JH);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().dhQ) {
                    au.a(view, MutiImgMutiPicLayout.this.Nj, MutiImgMutiPicLayout.this.NB, i, MutiImgMutiPicLayout.this.JH.axQ(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    au.a(MutiImgMutiPicLayout.this.JH, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    au.a(MutiImgMutiPicLayout.this.JH, view.getContext(), 3, false);
                } else {
                    au.a(view, MutiImgMutiPicLayout.this.Nj, MutiImgMutiPicLayout.this.NB, i, MutiImgMutiPicLayout.this.JH.axQ(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aAl = bjVar.aAl();
        if (v.isEmpty(aAl)) {
            this.Nw.setVisibility(8);
            this.Nz = false;
            return;
        }
        this.Nw.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aAl.get(0);
        this.Nw.setVoiceModel(voiceModel);
        this.Nw.setTag(voiceModel);
        this.Nw.bFO();
        if (voiceModel != null) {
            this.Nw.wQ(voiceModel.voice_status.intValue());
        }
        this.Nw.cKI();
        this.Nz = true;
    }

    private void setImageData(bj bjVar) {
        boolean z;
        ArrayList<MediaData> aAh = bjVar.aAh();
        if (i.axy().isShowImages() && v.getCount(aAh) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aAh.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aAh, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.NB = linkedList;
            this.Ny = true;
            if (linkedList.size() > 3) {
                this.NR.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.NR.setVisibility(0);
                z = true;
            } else {
                this.NR.setVisibility(8);
                z = false;
            }
            this.NL.setVisibility(8);
            if (v.getCount(linkedList) == 2) {
                this.NL.setVisibility(0);
                a((MediaData) v.getItem(aAh, 0), this.NM, z, false, 0);
                this.NN.setVisibility(8);
                a((MediaData) v.getItem(aAh, 1), this.NP, z, false, 1);
                return;
            } else if (v.getCount(linkedList) >= 3) {
                this.NL.setVisibility(0);
                this.NN.setVisibility(0);
                a((MediaData) v.getItem(aAh, 0), this.NM, z, false, 0);
                a((MediaData) v.getItem(aAh, 1), this.NN, z, false, 1);
                a((MediaData) v.getItem(aAh, 2), this.NP, z, true, 2);
                return;
            } else {
                this.NL.setVisibility(8);
                this.Ny = false;
                return;
            }
        }
        this.NL.setVisibility(8);
        this.Ny = false;
    }

    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JH = aVar;
        bj axQ = aVar.axQ();
        au.a(this.mTitle, axQ);
        au.a(this.Kf, this.mTitle, axQ, Kc);
        setImageData(axQ);
        setVoiceData(axQ);
        mX();
    }

    private void mX() {
        if (this.Kf.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ny) {
                setMarginsTop(this.Nw, Nt);
            } else if (this.Nz) {
                setMarginsTop(this.Nw, Nv);
            }
        } else if (this.Nw != null && this.Nw.getLayoutParams() != null) {
            if (this.Ny) {
                setMarginsTop(this.Nw, Nt);
            } else if (this.Nz) {
                setMarginsTop(this.Nw, Nu);
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

    public z<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.Lh;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.Lh = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int aX = aX(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.NM.getLayoutParams();
        layoutParams.width = aX;
        layoutParams.height = aX;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.NN.getLayoutParams();
        layoutParams2.width = aX;
        layoutParams2.height = aX;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.NP.getLayoutParams();
        layoutParams3.width = aX;
        layoutParams3.height = aX;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.NR.getLayoutParams();
        layoutParams4.width = aX;
        layoutParams4.height = aX;
        if (this.NL.getVisibility() != 8) {
            this.NM.setLayoutParams(layoutParams);
            this.NN.setLayoutParams(layoutParams2);
            this.NP.setLayoutParams(layoutParams3);
            this.NR.setLayoutParams(layoutParams4);
        }
    }

    private int aX(int i) {
        if (this.NH > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.NH;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.NH = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.NH;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.Nj ? 13 : 14;
        if (!aq.equals(a2, tbImageView.getUrl())) {
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
        tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.Nr);
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
        this.NT = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.NI != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.NI == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        private boolean NK;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.NK = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.NI != null) {
                MutiImgMutiPicLayout.this.NI.b(view, this.currentIndex, this.hasMore && this.NK);
            }
        }
    }
}
