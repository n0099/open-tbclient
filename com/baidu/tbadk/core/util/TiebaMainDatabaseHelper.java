package com.baidu.tbadk.core.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.j9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TiebaMainDatabaseHelper extends j9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DATABASE_VERSION = 25;
    public static final String TABLE_NAME_DOWNLOAD_INFO = "download_info";
    public static final String TABLE_NAME_LOCAL_GAME = "local_game";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiebaMainDatabaseHelper(Context context) {
        super(context, TbConfig.PHONE_DATEBASE_NAME, 25);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.j9
    public void clearAllTables(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS cash_data;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='cash_data';");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS account_data;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='account_data';");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS search_data;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='search_data';");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS search_post_data;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='search_post_data';");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS mark_data;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='mark_data';");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS draft_box;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='draft_box';");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS setting;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='setting';");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS chunk_upload_data;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='chunk_upload_data';");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS frs_image_forums;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP INDEX IF EXISTS idx_c_msgs_of;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='frs_image_forums';");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS chat_msgs;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP INDEX IF EXISTS idx_c_rfs_ost;");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='chat_msgs';");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS user_emotions");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS emotion_group");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS emotions");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS local_game");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS user_graffiti");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS activity_mission_info");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS download_info");
        }
    }

    @Override // com.baidu.tieba.j9
    public void createAllTables(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
            try {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists cash_data(type int,account varchar(30),data TEXT)");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255), personal_gid int, gender int, member_iconurl varchar(255),stoken varchar(255))");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists search_data(key, account, time)");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists search_post_data(key, account, time)");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum,subPost int,forumName varchar(30),forumId varchar(30),threadId varchar(30))");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists draft_box(account varchar(30),type int,forum_id varchar(20),forum_name TEXT,thread_id varchar(30),floor_id TEXT,title TEXT,content TEXT, time long)");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists setting(account varchar(30),frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time varchar(30),nodisturb_end_time varchar(30),remind_light,stranger_chat_switch int)");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists frs_image_forums(forum_name)");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists user_graffiti(pk INTEGER PRIMARY KEY AUTOINCREMENT, uid varchar(30), file_name varchar(128), md5 varchar(128))");
                prepareDBForV7(sQLiteDatabase);
                prepareDBForV11(sQLiteDatabase);
                prepareDBForV12(sQLiteDatabase);
                prepareDBForV16(sQLiteDatabase);
                prepareDBForV17(sQLiteDatabase);
                prepareDBForV18(sQLiteDatabase);
                prepareDBForV19V20V21(sQLiteDatabase);
                prepareDBForV23(sQLiteDatabase);
                prepareDBForV24(sQLiteDatabase);
                prepareDBForV25(sQLiteDatabase);
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "DatabaseHelper.createTables", new Object[0]);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.baidu.tieba.h9
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i, i2) == null) {
            if (i == 1) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
            }
            if (i < 3) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE mark_data ADD subPost int");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE mark_data ADD forumName varchar(30)");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE mark_data ADD forumId varchar(30)");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE mark_data ADD threadId varchar(30)");
            }
            if (i < 4) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD remind_tone");
            }
            if (i < 5) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists frs_image_forums(forum_name)");
            }
            if (i < 6) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists search_post_data(key, account, time)");
            }
            if (i < 7) {
                prepareDBForV7(sQLiteDatabase);
            }
            if (i < 8) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD msg_chat_switch DEFAULT 1");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_switch");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_start_time varchar(30)");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_end_time varchar(30)");
            }
            if (i < 9) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD portrait varchar(255)");
            }
            if (i < 10) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD personal_gid int");
            }
            if (i < 11) {
                prepareDBForV11(sQLiteDatabase);
            }
            if (i < 12) {
                prepareDBForV12(sQLiteDatabase);
            }
            if (i < 13) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD stranger_chat_switch int");
                prepareDBForV13(sQLiteDatabase);
            }
            if (i < 14) {
                prepareDBForV14(sQLiteDatabase);
            }
            if (i < 15) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD stoken varchar(255)");
            }
            if (i < 16) {
                prepareDBForV16(sQLiteDatabase);
            }
            if (i < 17) {
                prepareDBForV17(sQLiteDatabase);
            }
            if (i < 18) {
                prepareDBForV18(sQLiteDatabase);
            }
            if (i < 21) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS activity_mission_info");
                prepareDBForV19V20V21(sQLiteDatabase);
            }
            if (i < 23) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS download_info");
                prepareDBForV23(sQLiteDatabase);
            }
            if (i < 24) {
                prepareDBForV24(sQLiteDatabase);
            }
            if (i < 25) {
                prepareDBForV25(sQLiteDatabase);
            }
        }
    }

    public void prepareDBForV11(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, " CREATE TABLE if not exists user_emotions(id INTEGER primary key autoincrement, uid varchar(128), groupId varchar(64), updateTime bigint(21) default 0)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists idx_ue_uid ON user_emotions(uid)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists emotion_group(groupId varchar(64) primary key, groupName varchar(128), groupDesc text, emotionsCount int(11) default 0, width  int(11) default 0, height  int(11) default 0, status  int(11) default 0, bytesLength int(11) default 0, bytesReceived int(11) default 0, downloadUrl varchar(512), downloadTime bigint(21) default 0)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists idx_eg_gids ON emotion_group(groupId, status)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists emotions(sharpText varchar(512) primary key, groupId varchar(64), orderId int(11) default 0)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists idx_e_gido ON emotions(groupId, orderId)");
        }
    }

    public void prepareDBForV12(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists local_game(gameId varchar(64) primary key, gameName varchar(128), gameType int default 0, iconUrl varchar(128), gameLink  varchar(2),packageName varchar(64), launcherActivity  varchar(64),downloadTime varchar(64),installTime varchar(64))");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD remind_light int(11) default 1");
        }
    }

    public void prepareDBForV13(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD gender int");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD member_iconurl varchar(255)");
        }
    }

    public void prepareDBForV14(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists user_graffiti(pk INTEGER PRIMARY KEY AUTOINCREMENT, uid varchar(30), file_name varchar(128), md5 varchar(128))");
        }
    }

    public void prepareDBForV16(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists user_collect_emotion(pid varchar(30), uid varchar(30), sharp_text varchar(256), order_id int, width int, height int, pic_url varchar(512), thumbnail varchar(512), backup TEXT, primary key(pid, uid))");
        }
    }

    public void prepareDBForV17(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD zan_me_switch int");
        }
    }

    public void prepareDBForV18(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD name_show varchar(255)");
        }
    }

    public void prepareDBForV19V20V21(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists activity_mission_info(id INTEGER primary key autoincrement, activityid INTEGER, missionid INTEGER, activitysource TEXT, calltype INTEGER, tasktype INTEGER, browsetimepage TEXT, browsetime INTEGER, threadnum INTEGER, forumnum INTEGER, cleartype INTEGER, cleartime INTEGER, specificcleartime INTEGER, tid INTEGER, fid INTEGER, executingMissionList TEXT, totalLimit INTEGER, completedLimitCount INTEGER, threadtext TEXT, threadimg TEXT, threadforum INTEGER, token TEXT)");
        }
    }

    public void prepareDBForV23(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists download_info(id INTEGER primary key autoincrement, pkg_name TEXT NOT NULL, download_time INTEGER, item_info TEXT)");
        }
    }

    public void prepareDBForV24(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE download_info ADD COLUMN item_source  INTEGER DEFAULT 1");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE download_info ADD COLUMN storage_location  INTEGER DEFAULT 0");
        }
    }

    public void prepareDBForV25(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists user_diy_emotion(pid varchar(30), uid varchar(30), sharp_text varchar(256), order_id int, width int, height int, pic_url varchar(512), thumbnail varchar(512), backup TEXT, primary key(pid, uid))");
        }
    }

    public void prepareDBForV7(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists chat_msgs(pk INTEGER primary key autoincrement, msgId bigint,ownerId varchar(32), friendId varchar(32), msgType int(11) default 0, status int(11) default 0, localTime bigint(21) default 0, serverTime bigint(21) default 0, msgContent text)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists idx_c_msgs_of ON chat_msgs(ownerId, friendId, msgId)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists chat_recent_friends(pk varchar(64) primary key, unReadCount int(11) default 0 ,ownerId varchar(32), friendId varchar(32), ownerName varchar(64), friendName varchar(64), friendPortrait varchar(64), status int(11) default 0, localTime bigint(21) default 0, serverTime bigint(21) default 0, msgContent text)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists idx_c_rfs_ost ON chat_recent_friends(ownerId, serverTime)");
        }
    }
}
