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
            getIntent().putExtra("key_input_picture_path", bVar.gwf);
            getIntent().putExtra("key_sticker_path", bVar.gwi);
            getIntent().putExtra("key_input_video_path", bVar.gwg);
            getIntent().putExtra("key_output_video_path", bVar.gwh);
            getIntent().putExtra("key_need_mute", bVar.gwd);
            getIntent().putExtra("key_need_publish", bVar.gwj);
            getIntent().putExtra("key_story_state", bVar.state);
            getIntent().putExtra("key_need_composite", bVar.gwl);
            getIntent().putExtra("key_page_from", bVar.eZh);
            getIntent().putExtra("key_forum_name", bVar.forumName);
            getIntent().putExtra("key_forum_id", bVar.forumId);
        }
    }
}
