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
/* loaded from: classes20.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afq;
    private View.OnClickListener afr;
    private a aib;
    private TbImageView.c ajZ;
    protected boolean aks;
    protected String alA;
    protected long alB;
    protected long alC;
    private aa<AbsThreadDataSupport> alD;
    public TbImageView alq;
    private ImageView alr;
    private ImageView als;
    private TextView alt;
    private TextView alu;
    private TextView alv;
    private WeakReference<Context> alw;
    public RelativeLayout alx;
    public RelativeLayout aly;
    protected boolean alz;
    private Context mContext;
    protected long mFid;
    private int mSkinType;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.alw = null;
        this.aks = false;
        this.ajZ = new TbImageView.c() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
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
                    com.baidu.adp.widget.ImageView.a CI = c.bub().CI(com.baidu.adp.lib.e.c.mR().genCacheKey(tbImageView.getUrl(), 10));
                    if (CI != null) {
                        int width = CI.getWidth();
                        i = CI.getHeight();
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
                            if (VideoImageNoPlayerLayout.this.aks && i > i2) {
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
        this.alx = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.aly = (RelativeLayout) findViewById(R.id.video_container);
        this.alw = new WeakReference<>(TbadkCoreApplication.getInst());
        this.alq = (TbImageView) findViewById(R.id.video_thumbnail);
        this.alr = (ImageView) findViewById(R.id.video_play);
        this.als = (ImageView) findViewById(R.id.video_pause);
        this.alt = (TextView) findViewById(R.id.video_play_count);
        this.alu = (TextView) findViewById(R.id.video_play_flag);
        this.alv = (TextView) findViewById(R.id.video_duration);
        this.alq.setConrers(15);
        this.alq.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.alq.setDrawCorner(true);
        this.alq.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.alD != null) {
                    VideoImageNoPlayerLayout.this.alD.a(VideoImageNoPlayerLayout.this.alq, VideoImageNoPlayerLayout.this.afq);
                }
                if (VideoImageNoPlayerLayout.this.afr != null) {
                    VideoImageNoPlayerLayout.this.afr.onClick(VideoImageNoPlayerLayout.this.alq);
                }
            }
        });
        ap.setBackgroundResource(this, R.color.cp_bg_line_g);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.alx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null && absThreadDataSupport.bcY().efS != null) {
            OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bcY().efS;
            this.alz = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.alA = originalThreadInfo.threadId;
            this.alB = originalThreadInfo.videoInfo.video_length.intValue();
            this.alC = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.alv.setText(at.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.alt.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.alu.setVisibility(8);
            this.alq.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.aks = z;
    }

    public void setOnCardSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.alD = aaVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.aib = aVar;
        if (aVar != null) {
            ub();
        }
    }

    private void ub() {
        if (this.aly != null) {
            this.aly.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.aib.a(VideoImageNoPlayerLayout.this.afq);
                }
            });
        }
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.alx, R.color.cp_bg_line_g);
            ap.setBackgroundColor(this.aly, R.color.cp_bg_line_g);
            ap.setBackgroundColor(this, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afr = onClickListener;
    }
}
