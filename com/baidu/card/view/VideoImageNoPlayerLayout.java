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
import com.baidu.card.p;
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
/* loaded from: classes21.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afH;
    private View.OnClickListener afI;
    private a ait;
    protected boolean akK;
    private TbImageView.c akr;
    public TbImageView alI;
    private ImageView alJ;
    private ImageView alK;
    private TextView alL;
    private TextView alM;
    private TextView alN;
    private WeakReference<Context> alO;
    public RelativeLayout alP;
    public RelativeLayout alQ;
    protected boolean alR;
    protected String alS;
    protected long alT;
    protected long alU;
    private aa<AbsThreadDataSupport> alV;
    private Context mContext;
    protected long mFid;
    private int mSkinType;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.alO = null;
        this.akK = false;
        this.akr = new TbImageView.c() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
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
                    com.baidu.adp.widget.ImageView.a Du = c.bwL().Du(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), 10));
                    if (Du != null) {
                        int width = Du.getWidth();
                        i = Du.getHeight();
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
                            if (VideoImageNoPlayerLayout.this.akK && i > i2) {
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
        this.alP = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.alQ = (RelativeLayout) findViewById(R.id.video_container);
        this.alO = new WeakReference<>(TbadkCoreApplication.getInst());
        this.alI = (TbImageView) findViewById(R.id.video_thumbnail);
        this.alJ = (ImageView) findViewById(R.id.video_play);
        this.alK = (ImageView) findViewById(R.id.video_pause);
        this.alL = (TextView) findViewById(R.id.video_play_count);
        this.alM = (TextView) findViewById(R.id.video_play_flag);
        this.alN = (TextView) findViewById(R.id.video_duration);
        this.alI.setConrers(15);
        this.alI.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.alI.setDrawCorner(true);
        this.alI.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.alV != null) {
                    VideoImageNoPlayerLayout.this.alV.a(VideoImageNoPlayerLayout.this.alI, VideoImageNoPlayerLayout.this.afH);
                }
                if (VideoImageNoPlayerLayout.this.afI != null) {
                    VideoImageNoPlayerLayout.this.afI.onClick(VideoImageNoPlayerLayout.this.alI);
                }
            }
        });
        ap.setBackgroundResource(this, R.color.cp_bg_line_g);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.alP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null && absThreadDataSupport.bfG().erY != null) {
            OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bfG().erY;
            this.alR = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.alS = originalThreadInfo.threadId;
            this.alT = originalThreadInfo.videoInfo.video_length.intValue();
            this.alU = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.alN.setText(at.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.alL.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.alM.setVisibility(8);
            this.alI.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.akK = z;
    }

    public void setOnCardSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.alV = aaVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.ait = aVar;
        if (aVar != null) {
            ub();
        }
    }

    private void ub() {
        if (this.alQ != null) {
            this.alQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.ait.a(VideoImageNoPlayerLayout.this.afH);
                }
            });
        }
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.alP, R.color.cp_bg_line_g);
            ap.setBackgroundColor(this.alQ, R.color.cp_bg_line_g);
            ap.setBackgroundColor(this, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afI = onClickListener;
    }
}
