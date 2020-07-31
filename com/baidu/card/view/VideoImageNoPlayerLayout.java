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
import com.baidu.adp.lib.util.l;
import com.baidu.card.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.lang.ref.WeakReference;
/* loaded from: classes15.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    private View.OnClickListener adR;
    private a agx;
    protected boolean aiI;
    private TbImageView.c aik;
    private ImageView ajA;
    private ImageView ajB;
    private TextView ajC;
    private TextView ajD;
    private TextView ajE;
    private WeakReference<Context> ajF;
    public RelativeLayout ajG;
    public RelativeLayout ajH;
    protected boolean ajI;
    protected String ajJ;
    protected long ajK;
    protected long ajL;
    private aa<AbsThreadDataSupport> ajM;
    public TbImageView ajz;
    private Context mContext;
    protected long mFid;
    private int mSkinType;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ajF = null;
        this.aiI = false;
        this.aik = new TbImageView.c() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
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
                    com.baidu.adp.widget.ImageView.a zV = c.bkk().zV(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), 10));
                    if (zV != null) {
                        int width = zV.getWidth();
                        i = zV.getHeight();
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
                            if (VideoImageNoPlayerLayout.this.aiI && i > i2) {
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
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_image_no_player_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ajG = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.ajH = (RelativeLayout) findViewById(R.id.video_container);
        this.ajF = new WeakReference<>(TbadkCoreApplication.getInst());
        this.ajz = (TbImageView) findViewById(R.id.video_thumbnail);
        this.ajA = (ImageView) findViewById(R.id.video_play);
        this.ajB = (ImageView) findViewById(R.id.video_pause);
        this.ajC = (TextView) findViewById(R.id.video_play_count);
        this.ajD = (TextView) findViewById(R.id.video_play_flag);
        this.ajE = (TextView) findViewById(R.id.video_duration);
        this.ajz.setConrers(15);
        this.ajz.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.ajz.setDrawCorner(true);
        this.ajz.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.ajM != null) {
                    VideoImageNoPlayerLayout.this.ajM.a(VideoImageNoPlayerLayout.this.ajz, VideoImageNoPlayerLayout.this.adQ);
                }
                if (VideoImageNoPlayerLayout.this.adR != null) {
                    VideoImageNoPlayerLayout.this.adR.onClick(VideoImageNoPlayerLayout.this.ajz);
                }
            }
        });
        ao.setBackgroundResource(this, R.color.cp_bg_line_g);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.ajG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && absThreadDataSupport.aTN().dUi != null) {
            OriginalThreadInfo originalThreadInfo = absThreadDataSupport.aTN().dUi;
            this.ajI = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.ajJ = originalThreadInfo.threadId;
            this.ajK = originalThreadInfo.videoInfo.video_length.intValue();
            this.ajL = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.ajE.setText(as.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.ajC.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), as.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.ajD.setVisibility(8);
            this.ajz.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.aiI = z;
    }

    public void setOnCardSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ajM = aaVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.agx = aVar;
        if (aVar != null) {
            sk();
        }
    }

    private void sk() {
        if (this.ajH != null) {
            this.ajH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.agx.a(VideoImageNoPlayerLayout.this.adQ);
                }
            });
        }
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundColor(this.ajG, R.color.cp_bg_line_g);
            ao.setBackgroundColor(this.ajH, R.color.cp_bg_line_g);
            ao.setBackgroundColor(this, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adR = onClickListener;
    }
}
