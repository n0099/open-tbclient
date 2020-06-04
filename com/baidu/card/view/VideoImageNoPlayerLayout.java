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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adw;
    private View.OnClickListener adx;
    private a afV;
    protected boolean ahG;
    private TbImageView.c ahi;
    public TbImageView aii;
    private ImageView aij;
    private ImageView aik;
    private TextView ail;
    private TextView aim;
    private TextView ain;
    private WeakReference<Context> aio;
    public RelativeLayout aip;
    public RelativeLayout aiq;
    protected boolean air;
    protected String ais;
    protected long ait;
    protected long aiu;
    private aa<AbsThreadDataSupport> aiv;
    private Context mContext;
    protected long mFid;
    protected String mFrom;
    private int mSkinType;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aio = null;
        this.ahG = false;
        this.ahi = new TbImageView.c() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
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
                    com.baidu.adp.widget.ImageView.a yv = c.beu().yv(com.baidu.adp.lib.e.c.kX().genCacheKey(tbImageView.getUrl(), 10));
                    if (yv != null) {
                        int width = yv.getWidth();
                        i = yv.getHeight();
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
                            if (VideoImageNoPlayerLayout.this.ahG && i > i2) {
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
        this.aip = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.aiq = (RelativeLayout) findViewById(R.id.video_container);
        this.aio = new WeakReference<>(TbadkCoreApplication.getInst());
        this.aii = (TbImageView) findViewById(R.id.video_thumbnail);
        this.aij = (ImageView) findViewById(R.id.video_play);
        this.aik = (ImageView) findViewById(R.id.video_pause);
        this.ail = (TextView) findViewById(R.id.video_play_count);
        this.aim = (TextView) findViewById(R.id.video_play_flag);
        this.ain = (TextView) findViewById(R.id.video_duration);
        this.aii.setConrers(15);
        this.aii.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.aii.setDrawCorner(true);
        this.aii.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.aiv != null) {
                    VideoImageNoPlayerLayout.this.aiv.a(VideoImageNoPlayerLayout.this.aii, VideoImageNoPlayerLayout.this.adw);
                }
                if (VideoImageNoPlayerLayout.this.adx != null) {
                    VideoImageNoPlayerLayout.this.adx.onClick(VideoImageNoPlayerLayout.this.aii);
                }
            }
        });
        am.setBackgroundResource(this, R.color.cp_bg_line_g);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.aip;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
            OriginalThreadInfo originalThreadInfo = absThreadDataSupport.aOi().dHm;
            this.air = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.ais = originalThreadInfo.threadId;
            this.ait = originalThreadInfo.videoInfo.video_length.intValue();
            this.aiu = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.ain.setText(aq.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.ail.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.aim.setVisibility(8);
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if (originalThreadInfo.videoInfo.wth_mid_loc != null && originalThreadInfo.videoInfo.hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                this.aii.setScaleType(ImageView.ScaleType.MATRIX);
                this.aii.setIsSmartCrop(true);
                setCanCenterStart(true);
                if (this.air) {
                    this.ain.setText("");
                    this.ail.setText("");
                    this.aim.setVisibility(0);
                }
                this.aii.setSmartCropCenterPointWidthRatio(originalThreadInfo.videoInfo.wth_mid_loc.floatValue());
                this.aii.setSmartCropCenterPointHeightRatio(originalThreadInfo.videoInfo.hth_mid_loc.floatValue());
                this.aii.setOnDrawListener(this.ahi);
            }
            this.aii.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.ahG = z;
    }

    public void setOnCardSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.aiv = aaVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.afV = aVar;
        if (aVar != null) {
            rQ();
        }
    }

    private void rQ() {
        if (this.aiq != null) {
            this.aiq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.afV.a(VideoImageNoPlayerLayout.this.adw);
                }
            });
        }
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.aip, R.color.cp_bg_line_g);
            am.setBackgroundColor(this.aiq, R.color.cp_bg_line_g);
            am.setBackgroundColor(this, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adx = onClickListener;
    }
}
