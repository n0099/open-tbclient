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
import com.baidu.card.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements i<com.baidu.tbadk.core.data.a> {
    public TextView VC;
    private com.baidu.tbadk.core.data.a Vq;
    private ab<com.baidu.tbadk.core.data.a> Wu;
    private boolean XJ;
    public PlayVoiceBntNew XS;
    private boolean XU;
    private boolean XV;
    private LinkedList<MediaData> XW;
    private int Yc;
    private d Yd;
    public RelativeLayout Yg;
    public TbImageView Yh;
    public TbImageView Yi;
    public TbImageView Yj;
    private TextView Yl;
    protected boolean Ym;
    private String mFrom;
    private int mLastScreenWidth;
    private TbImageView.b mOnDrawListener;
    public TextView mTitle;
    private static final int XP = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int XQ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int XR = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int VA = l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XJ = true;
        this.Vq = null;
        this.XU = false;
        this.XV = false;
        this.Yc = 0;
        this.Ym = false;
        this.mLastScreenWidth = 0;
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a qr = c.asp().qr(com.baidu.adp.lib.f.c.iv().e(tbImageView.getUrl(), MutiImgMutiPicLayout.this.XJ ? 13 : 14));
                    if (qr != null) {
                        int width = qr.getWidth();
                        i = qr.getHeight();
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
                            if (MutiImgMutiPicLayout.this.Ym && i > i2) {
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
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.VC = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.XS = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.XS.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.Vq);
                }
            }
        });
        this.Yg = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.Yh = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.Yh.setDrawCorner(true);
        this.Yh.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.Yh.setDefaultBgResource(e.get());
        this.Yh.setConrers(5);
        this.Yi = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.Yi.setDrawCorner(false);
        this.Yi.setDefaultBgResource(e.get());
        this.Yi.setRadius(0);
        this.Yi.setConrers(0);
        this.Yj = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.Yj.setDrawCorner(true);
        this.Yj.setDefaultBgResource(e.get());
        this.Yj.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.Yj.setConrers(10);
        this.Yl = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.Yd = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.Vq.objType = 2;
                    subClickListener.Xp = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.Vq);
                }
                au.a(view, MutiImgMutiPicLayout.this.XJ, MutiImgMutiPicLayout.this.XW, i, MutiImgMutiPicLayout.this.Vq.abv(), MutiImgMutiPicLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> adJ = bgVar.adJ();
        if (v.aa(adJ)) {
            this.XS.setVisibility(8);
            this.XV = false;
            return;
        }
        this.XS.setVisibility(0);
        VoiceData.VoiceModel voiceModel = adJ.get(0);
        this.XS.setVoiceModel(voiceModel);
        this.XS.setTag(voiceModel);
        this.XS.bFA();
        if (voiceModel != null) {
            this.XS.vx(voiceModel.voice_status.intValue());
        }
        this.XS.cnD();
        this.XV = true;
    }

    private void setImageData(bg bgVar) {
        boolean z;
        ArrayList<MediaData> adF = bgVar.adF();
        if (com.baidu.tbadk.core.i.abb().abf() && v.Z(adF) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < adF.size(); i++) {
                MediaData mediaData = (MediaData) v.c(adF, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.XW = linkedList;
            this.XU = true;
            if (linkedList.size() > 3) {
                this.Yl.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.Yl.setVisibility(0);
                z = true;
            } else {
                this.Yl.setVisibility(8);
                z = false;
            }
            this.Yg.setVisibility(8);
            if (v.Z(linkedList) == 2) {
                this.Yg.setVisibility(0);
                a((MediaData) v.c(adF, 0), this.Yh, z, false, 0);
                this.Yi.setVisibility(8);
                a((MediaData) v.c(adF, 1), this.Yj, z, false, 1);
                return;
            } else if (v.Z(linkedList) >= 3) {
                this.Yg.setVisibility(0);
                this.Yi.setVisibility(0);
                a((MediaData) v.c(adF, 0), this.Yh, z, false, 0);
                a((MediaData) v.c(adF, 1), this.Yi, z, false, 1);
                a((MediaData) v.c(adF, 2), this.Yj, z, true, 2);
                return;
            } else {
                this.Yg.setVisibility(8);
                this.XU = false;
                return;
            }
        }
        this.Yg.setVisibility(8);
        this.XU = false;
    }

    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vq = aVar;
        bg abv = aVar.abv();
        au.a(this.mTitle, abv);
        au.a(this.VC, this.mTitle, abv, VA);
        setImageData(abv);
        setVoiceData(abv);
        qw();
    }

    private void qw() {
        if (this.VC.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.XU) {
                setMarginsTop(this.XS, XP);
            } else if (this.XV) {
                setMarginsTop(this.XS, XR);
            }
        } else if (this.XS != null && this.XS.getLayoutParams() != null) {
            if (this.XU) {
                setMarginsTop(this.XS, XP);
            } else if (this.XV) {
                setMarginsTop(this.XS, XQ);
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

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.Wu;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Wu = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bz = bz(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Yh.getLayoutParams();
        layoutParams.width = bz;
        layoutParams.height = bz;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Yi.getLayoutParams();
        layoutParams2.width = bz;
        layoutParams2.height = bz;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Yj.getLayoutParams();
        layoutParams3.width = bz;
        layoutParams3.height = bz;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.Yl.getLayoutParams();
        layoutParams4.width = bz;
        layoutParams4.height = bz;
        if (this.Yg.getVisibility() != 8) {
            this.Yh.setLayoutParams(layoutParams);
            this.Yi.setLayoutParams(layoutParams2);
            this.Yj.setLayoutParams(layoutParams3);
            this.Yl.setLayoutParams(layoutParams4);
        }
    }

    private int bz(int i) {
        if (this.Yc > 0) {
            int af = l.af(getContext());
            if (af == this.mLastScreenWidth) {
                return this.Yc;
            }
            this.mLastScreenWidth = af;
        }
        this.Yc = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.Yc;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.XJ ? 13 : 14;
        if (!ap.equals(a2, tbImageView.getUrl())) {
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
        tbImageView.setBorderColor(al.getColor(R.color.black_alpha8));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.mOnDrawListener);
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
        this.Ym = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.Yd != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.Yd == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean Yf;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Yf = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.Yd != null) {
                MutiImgMutiPicLayout.this.Yd.a(view, this.currentIndex, this.hasMore && this.Yf);
            }
        }
    }
}
