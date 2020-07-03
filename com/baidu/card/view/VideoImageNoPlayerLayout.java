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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport aea;
    private View.OnClickListener aeb;
    private a agG;
    protected boolean aiQ;
    private TbImageView.c ais;
    public TbImageView ajE;
    private ImageView ajF;
    private ImageView ajG;
    private TextView ajH;
    private TextView ajI;
    private TextView ajJ;
    private WeakReference<Context> ajK;
    public RelativeLayout ajL;
    public RelativeLayout ajM;
    protected boolean ajN;
    protected String ajO;
    protected long ajP;
    protected long ajQ;
    private aa<AbsThreadDataSupport> ajR;
    private Context mContext;
    protected long mFid;
    private int mSkinType;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ajK = null;
        this.aiQ = false;
        this.ais = new TbImageView.c() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
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
                    com.baidu.adp.widget.ImageView.a yO = c.bgz().yO(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), 10));
                    if (yO != null) {
                        int width = yO.getWidth();
                        i = yO.getHeight();
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
                            if (VideoImageNoPlayerLayout.this.aiQ && i > i2) {
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
        this.ajL = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.ajM = (RelativeLayout) findViewById(R.id.video_container);
        this.ajK = new WeakReference<>(TbadkCoreApplication.getInst());
        this.ajE = (TbImageView) findViewById(R.id.video_thumbnail);
        this.ajF = (ImageView) findViewById(R.id.video_play);
        this.ajG = (ImageView) findViewById(R.id.video_pause);
        this.ajH = (TextView) findViewById(R.id.video_play_count);
        this.ajI = (TextView) findViewById(R.id.video_play_flag);
        this.ajJ = (TextView) findViewById(R.id.video_duration);
        this.ajE.setConrers(15);
        this.ajE.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.ajE.setDrawCorner(true);
        this.ajE.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.ajR != null) {
                    VideoImageNoPlayerLayout.this.ajR.a(VideoImageNoPlayerLayout.this.ajE, VideoImageNoPlayerLayout.this.aea);
                }
                if (VideoImageNoPlayerLayout.this.aeb != null) {
                    VideoImageNoPlayerLayout.this.aeb.onClick(VideoImageNoPlayerLayout.this.ajE);
                }
            }
        });
        an.setBackgroundResource(this, R.color.cp_bg_line_g);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.ajL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && absThreadDataSupport.aPS().dNX != null) {
            OriginalThreadInfo originalThreadInfo = absThreadDataSupport.aPS().dNX;
            this.ajN = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.ajO = originalThreadInfo.threadId;
            this.ajP = originalThreadInfo.videoInfo.video_length.intValue();
            this.ajQ = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.ajJ.setText(ar.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.ajH.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), ar.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.ajI.setVisibility(8);
            this.ajE.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.aiQ = z;
    }

    public void setOnCardSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ajR = aaVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.agG = aVar;
        if (aVar != null) {
            si();
        }
    }

    private void si() {
        if (this.ajM != null) {
            this.ajM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.agG.a(VideoImageNoPlayerLayout.this.aea);
                }
            });
        }
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundColor(this.ajL, R.color.cp_bg_line_g);
            an.setBackgroundColor(this.ajM, R.color.cp_bg_line_g);
            an.setBackgroundColor(this, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeb = onClickListener;
    }
}
