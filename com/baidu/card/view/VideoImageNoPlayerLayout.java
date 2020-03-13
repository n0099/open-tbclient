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
import com.baidu.card.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements m<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a Kc;
    private View.OnClickListener Ke;
    private a MI;
    private TbImageView.c NT;
    public TbImageView OY;
    private ImageView OZ;
    protected boolean Ou;
    private ImageView Pa;
    private TextView Pb;
    private TextView Pc;
    private TextView Pe;
    private WeakReference<Context> Pf;
    public RelativeLayout Pg;
    public RelativeLayout Ph;
    protected boolean Pi;
    protected String Pj;
    protected long Pk;
    protected long Pl;
    private z<com.baidu.tbadk.core.data.a> Pm;
    private Context mContext;
    protected long mFid;
    protected String mFrom;
    private int mSkinType;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Pf = null;
        this.Ou = false;
        this.NT = new TbImageView.c() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
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
                    com.baidu.adp.widget.ImageView.a vy = c.aPR().vy(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), 10));
                    if (vy != null) {
                        int width = vy.getWidth();
                        i = vy.getHeight();
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
                            if (VideoImageNoPlayerLayout.this.Ou && i > i2) {
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
        this.Pg = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.Ph = (RelativeLayout) findViewById(R.id.video_container);
        this.Pf = new WeakReference<>(TbadkCoreApplication.getInst());
        this.OY = (TbImageView) findViewById(R.id.video_thumbnail);
        this.OZ = (ImageView) findViewById(R.id.video_play);
        this.Pa = (ImageView) findViewById(R.id.video_pause);
        this.Pb = (TextView) findViewById(R.id.video_play_count);
        this.Pc = (TextView) findViewById(R.id.video_play_flag);
        this.Pe = (TextView) findViewById(R.id.video_duration);
        this.OY.setConrers(15);
        this.OY.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.OY.setDrawCorner(true);
        this.OY.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.Pm != null) {
                    VideoImageNoPlayerLayout.this.Pm.a(VideoImageNoPlayerLayout.this.OY, VideoImageNoPlayerLayout.this.Kc);
                }
                if (VideoImageNoPlayerLayout.this.Ke != null) {
                    VideoImageNoPlayerLayout.this.Ke.onClick(VideoImageNoPlayerLayout.this.OY);
                }
            }
        });
        am.setBackgroundResource(this, R.color.cp_bg_line_g);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.Pg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.aAg() != null && aVar.aAg().cTR != null) {
            OriginalThreadInfo originalThreadInfo = aVar.aAg().cTR;
            this.Pi = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.Pj = originalThreadInfo.threadId;
            this.Pk = originalThreadInfo.videoInfo.video_length.intValue();
            this.Pl = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.Pe.setText(aq.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.Pb.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.Pc.setVisibility(8);
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if (originalThreadInfo.videoInfo.wth_mid_loc != null && originalThreadInfo.videoInfo.hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                this.OY.setScaleType(ImageView.ScaleType.MATRIX);
                this.OY.setIsSmartCrop(true);
                setCanCenterStart(true);
                if (this.Pi) {
                    this.Pe.setText("");
                    this.Pb.setText("");
                    this.Pc.setVisibility(0);
                }
                this.OY.setSmartCropCenterPointWidthRatio(originalThreadInfo.videoInfo.wth_mid_loc.floatValue());
                this.OY.setSmartCropCenterPointHeightRatio(originalThreadInfo.videoInfo.hth_mid_loc.floatValue());
                this.OY.setOnDrawListener(this.NT);
            }
            this.OY.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.Ou = z;
    }

    public void setOnCardSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.Pm = zVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.MI = aVar;
        if (aVar != null) {
            no();
        }
    }

    private void no() {
        if (this.Ph != null) {
            this.Ph.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.MI.a(VideoImageNoPlayerLayout.this.Kc);
                }
            });
        }
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.Pg, R.color.cp_bg_line_g);
            am.setBackgroundColor(this.Ph, R.color.cp_bg_line_g);
            am.setBackgroundColor(this, R.color.cp_bg_line_g);
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.Ke = onClickListener;
    }
}
