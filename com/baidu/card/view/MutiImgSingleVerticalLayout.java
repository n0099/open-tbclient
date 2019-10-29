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
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.a.b;
import com.baidu.card.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
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
public class MutiImgSingleVerticalLayout extends LinearLayout implements i<com.baidu.tbadk.core.data.a> {
    public TextView FK;
    private com.baidu.tbadk.core.data.a Fx;
    private ab<com.baidu.tbadk.core.data.a> GD;
    private boolean HY;
    protected boolean IC;
    public TbImageView IF;
    private MediaData IH;
    private int II;
    private int IJ;
    private TbImageView.b Id;
    public PlayVoiceBntNew Ii;
    private boolean Ik;
    private boolean Il;
    private LinkedList<MediaData> Im;
    private int Is;
    private d It;
    private String mFrom;
    public TextView mTitle;
    private static final int If = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Ig = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Ih = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int FI = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgSingleVerticalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleVerticalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HY = true;
        this.Fx = null;
        this.Ik = false;
        this.Il = false;
        this.Is = 0;
        this.II = 0;
        this.IJ = 0;
        this.IC = false;
        this.Id = new TbImageView.b() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.3
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
                    com.baidu.adp.widget.ImageView.a pY = c.avu().pY(com.baidu.adp.lib.f.c.fT().genCacheKey(tbImageView.getUrl(), MutiImgSingleVerticalLayout.this.HY ? 13 : 14));
                    if (pY != null) {
                        int width = pY.getWidth();
                        i = pY.getHeight();
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
                            if (MutiImgSingleVerticalLayout.this.IC && i > i2) {
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
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.FK = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ii = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ii.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgSingleVerticalLayout.this.Fx);
                }
            }
        });
        this.IF = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.IF.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.IF.setConrers(15);
        this.IF.setDrawCorner(true);
        this.IF.setDefaultBgResource(e.Vl());
        this.IF.setLongIconSupport(true);
        this.IF.setGifIconSupport(true);
        this.It = new d() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgSingleVerticalLayout.this.Fx.objType = 2;
                    subClickListener.HC = false;
                    subClickListener.a(view, MutiImgSingleVerticalLayout.this.Fx);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().cuK) {
                    au.a(view, MutiImgSingleVerticalLayout.this.HY, MutiImgSingleVerticalLayout.this.Im, i, MutiImgSingleVerticalLayout.this.Fx.agI(), MutiImgSingleVerticalLayout.this.mFrom);
                } else if ("index".equals(MutiImgSingleVerticalLayout.this.mFrom)) {
                    au.a(MutiImgSingleVerticalLayout.this.Fx, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgSingleVerticalLayout.this.mFrom)) {
                    au.a(MutiImgSingleVerticalLayout.this.Fx, view.getContext(), 3, false);
                } else {
                    au.a(view, MutiImgSingleVerticalLayout.this.HY, MutiImgSingleVerticalLayout.this.Im, i, MutiImgSingleVerticalLayout.this.Fx.agI(), MutiImgSingleVerticalLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bh bhVar) {
        ArrayList<VoiceData.VoiceModel> aiU = bhVar.aiU();
        if (v.isEmpty(aiU)) {
            this.Ii.setVisibility(8);
            this.Il = false;
            return;
        }
        this.Ii.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aiU.get(0);
        this.Ii.setVoiceModel(voiceModel);
        this.Ii.setTag(voiceModel);
        this.Ii.bnq();
        if (voiceModel != null) {
            this.Ii.uK(voiceModel.voice_status.intValue());
        }
        this.Ii.cpC();
        this.Il = true;
    }

    private void setImageData(bh bhVar) {
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        if (com.baidu.tbadk.core.i.agq().isShowImages() && v.getCount(aiQ) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aiQ.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiQ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.Im = linkedList;
            this.Ik = true;
            this.IF.setVisibility(8);
            if (v.getCount(linkedList) == 1) {
                this.IF.setVisibility(0);
                this.IH = (MediaData) v.getItem(aiQ, 0);
                a((MediaData) v.getItem(aiQ, 0), this.IF, true, false, true, 0);
                return;
            }
            this.IF.setVisibility(8);
            this.Ik = false;
            return;
        }
        this.IF.setVisibility(8);
        this.Ik = false;
    }

    public void setFromCDN(boolean z) {
        this.HY = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.Fx = aVar;
        bh agI = aVar.agI();
        au.a(this.mTitle, agI);
        au.a(this.FK, this.mTitle, agI, FI);
        setImageData(agI);
        setVoiceData(agI);
        lZ();
    }

    private void lZ() {
        if (this.FK.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ik) {
                setMarginsTop(this.Ii, If);
            } else if (this.Il) {
                setMarginsTop(this.Ii, Ih);
            }
        } else if (this.Ii != null && this.Ii.getLayoutParams() != null) {
            if (this.Ik) {
                setMarginsTop(this.Ii, If);
            } else if (this.Il) {
                setMarginsTop(this.Ii, Ig);
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
        return this.GD;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.GD = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.HY ? 13 : 14;
        if (!aq.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        setCanCenterStart(true);
        boolean isLongPic = mediaData.isLongPic();
        boolean isSmartCrop = mediaData.isSmartCrop();
        tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
        tbImageView.setIsLongPic(isLongPic);
        tbImageView.setIsSmartCrop(isSmartCrop);
        tbImageView.setSmartCropCenterPointWidthRatio((float) mediaData.getSmartCropCenterPointWidthRatio());
        tbImageView.setSmartCropCenterPointHeightRatio((float) mediaData.getSmartCropCenterPointHeightRatio());
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDefaultBgResource(e.Vl());
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.Id);
        tbImageView.startLoad(a2, i2, false);
        a(tbImageView, i, z2, z3);
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
        this.IC = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.It != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.It == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean Iv;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Iv = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgSingleVerticalLayout.this.It != null) {
                MutiImgSingleVerticalLayout.this.It.b(view, this.currentIndex, this.hasMore && this.Iv);
            }
        }
    }
}
