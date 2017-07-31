package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.story.process.b;
/* loaded from: classes.dex */
public class StoryCompositeServiceConfig extends IntentConfig {
    public StoryCompositeServiceConfig(Context context, b bVar) {
        super(context);
        setIntentAction(IntentAction.StartService);
        if (bVar != null) {
            getIntent().putExtra("key_input_type", bVar.type);
            getIntent().putExtra("key_input_picture_path", bVar.gce);
            getIntent().putExtra("key_sticker_path", bVar.gch);
            getIntent().putExtra("key_input_video_path", bVar.gcf);
            getIntent().putExtra("key_output_video_path", bVar.gcg);
            getIntent().putExtra("key_need_mute", bVar.gcc);
            getIntent().putExtra("key_need_publish", bVar.gci);
            getIntent().putExtra("key_story_state", bVar.state);
            getIntent().putExtra("key_need_composite", bVar.gck);
            getIntent().putExtra("key_page_from", bVar.fXp);
            getIntent().putExtra("key_forum_name", bVar.forumName);
            getIntent().putExtra("key_forum_id", bVar.forumId);
        }
    }
}
