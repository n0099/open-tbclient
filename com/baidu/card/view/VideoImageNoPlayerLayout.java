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
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.lang.ref.WeakReference;
/* loaded from: classes15.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements o<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeW;
    private View.OnClickListener aeX;
    private a ahF;
    protected boolean ajX;
    private TbImageView.c ajz;
    public TbImageView akO;
    private ImageView akP;
    private ImageView akQ;
    private TextView akR;
    private TextView akS;
    private TextView akT;
    private WeakReference<Context> akU;
    public RelativeLayout akV;
    public RelativeLayout akW;
    protected boolean akX;
    protected String akY;
    protected long akZ;
    protected long ala;
    private aa<AbsThreadDataSupport> alb;
    private Context mContext;
    protected long mFid;
    private int mSkinType;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.akU = null;
        this.ajX = false;
        this.ajz = new TbImageView.c() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
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
                    com.baidu.adp.widget.ImageView.a Cl = c.bsW().Cl(com.baidu.adp.lib.e.c.mM().genCacheKey(tbImageView.getUrl(), 10));
                    if (Cl != null) {
                        int width = Cl.getWidth();
                        i = Cl.getHeight();
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
                            if (VideoImageNoPlayerLayout.this.ajX && i > i2) {
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
        this.akV = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.akW = (RelativeLayout) findViewById(R.id.video_container);
        this.akU = new WeakReference<>(TbadkCoreApplication.getInst());
        this.akO = (TbImageView) findViewById(R.id.video_thumbnail);
        this.akP = (ImageView) findViewById(R.id.video_play);
        this.akQ = (ImageView) findViewById(R.id.video_pause);
        this.akR = (TextView) findViewById(R.id.video_play_count);
        this.akS = (TextView) findViewById(R.id.video_play_flag);
        this.akT = (TextView) findViewById(R.id.video_duration);
        this.akO.setConrers(15);
        this.akO.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.akO.setDrawCorner(true);
        this.akO.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.alb != null) {
                    VideoImageNoPlayerLayout.this.alb.a(VideoImageNoPlayerLayout.this.akO, VideoImageNoPlayerLayout.this.aeW);
                }
                if (VideoImageNoPlayerLayout.this.aeX != null) {
                    VideoImageNoPlayerLayout.this.aeX.onClick(VideoImageNoPlayerLayout.this.akO);
                }
            }
        });
        ap.setBackgroundResource(this, R.color.cp_bg_line_g);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.akV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edE != null) {
            OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bce().edE;
            this.akX = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.akY = originalThreadInfo.threadId;
            this.akZ = originalThreadInfo.videoInfo.video_length.intValue();
            this.ala = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.akT.setText(at.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.akR.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.akS.setVisibility(8);
            this.akO.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.ajX = z;
    }

    public void setOnCardSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.alb = aaVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.ahF = aVar;
        if (aVar != null) {
            tV();
        }
    }

    private void tV() {
        if (this.akW != null) {
            this.akW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.ahF.a(VideoImageNoPlayerLayout.this.aeW);
                }
            });
        }
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.akV, R.color.cp_bg_line_g);
            ap.setBackgroundColor(this.akW, R.color.cp_bg_line_g);
            ap.setBackgroundColor(this, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeX = onClickListener;
    }
}
