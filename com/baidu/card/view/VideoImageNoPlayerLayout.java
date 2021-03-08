package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.d;
import com.baidu.card.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahB;
    private View.OnClickListener ahC;
    private a akt;
    protected boolean amJ;
    private TbImageView.c amp;
    public TbImageView anK;
    public View anL;
    private ImageView anM;
    private ImageView anN;
    private TextView anO;
    private TextView anP;
    private TextView anQ;
    public RelativeLayout anR;
    public RelativeLayout anS;
    protected boolean anT;
    protected String anU;
    protected long anV;
    protected long anW;
    private ab<com.baidu.tbadk.core.data.a> anX;
    private Context mContext;
    protected long mFid;
    private int mSkinType;
    private WeakReference<Context> mWeakContext;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mWeakContext = null;
        this.amJ = false;
        this.amp = new TbImageView.c() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
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
                    com.baidu.adp.widget.ImageView.a Dp = c.bCS().Dp(d.mw().genCacheKey(tbImageView.getUrl(), 10));
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
                            if (VideoImageNoPlayerLayout.this.amJ && i > i2) {
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
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_image_no_player_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.anR = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.anS = (RelativeLayout) findViewById(R.id.video_container);
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        this.anK = (TbImageView) findViewById(R.id.video_thumbnail);
        this.anL = findViewById(R.id.video_thumbnail_mask);
        this.anM = (ImageView) findViewById(R.id.video_play);
        this.anN = (ImageView) findViewById(R.id.video_pause);
        this.anO = (TextView) findViewById(R.id.video_play_count);
        this.anP = (TextView) findViewById(R.id.video_play_flag);
        this.anQ = (TextView) findViewById(R.id.video_duration);
        this.anK.setConrers(15);
        this.anK.setRadiusById(R.string.J_X05);
        this.anK.setDrawCorner(true);
        this.anK.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.anX != null) {
                    VideoImageNoPlayerLayout.this.anX.a(VideoImageNoPlayerLayout.this.anK, VideoImageNoPlayerLayout.this.ahB);
                }
                if (VideoImageNoPlayerLayout.this.ahC != null) {
                    VideoImageNoPlayerLayout.this.ahC.onClick(VideoImageNoPlayerLayout.this.anK);
                }
            }
        });
        ap.setBackgroundResource(this, R.color.CAM_X0206);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.anR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.blp() != null && aVar.blp().eUD != null) {
            OriginalThreadInfo originalThreadInfo = aVar.blp().eUD;
            this.anT = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.anU = originalThreadInfo.threadId;
            this.anV = originalThreadInfo.videoInfo.video_length.intValue();
            this.anW = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.anQ.setText(au.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.anO.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), au.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.anP.setVisibility(8);
            this.anK.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.amJ = z;
    }

    public void setOnCardSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.anX = abVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.akt = aVar;
        if (aVar != null) {
            tp();
        }
    }

    private void tp() {
        if (this.anS != null) {
            this.anS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.akt.a(VideoImageNoPlayerLayout.this.ahB);
                }
            });
        }
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.anL).of(R.array.Mask_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.anL).oh(R.string.J_X05);
            ap.setBackgroundColor(this.anR, R.color.CAM_X0206);
            ap.setBackgroundColor(this.anS, R.color.CAM_X0206);
            ap.setBackgroundColor(this, R.color.CAM_X0206);
            this.anM.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.anN.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.ahC = onClickListener;
    }
}
